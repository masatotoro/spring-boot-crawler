#!/bin/bash -xv
# -*- mode: bash; coding: utf-8-unix  -*-

cat /etc/redhat-release
yum update -y
yum install -y wget


: "install java" && {
    yum install -y java-1.8.0-openjdk
    java -version
}

: "install mongo db" && {
    cat <<'EOF' > /etc/yum.repos.d/mongodb-org-4.0.repo
[mongodb-org-4.0]
name=MongoDB Repository
baseurl=https://repo.mongodb.org/yum/redhat/$releasever/mongodb-org/4.0/x86_64/
gpgcheck=1
enabled=1
gpgkey=https://www.mongodb.org/static/pgp/server-4.0.asc
EOF

    cat <<EOF > /etc/mongod.conf
# mongod.conf
# for documentation of all options, see:
#   http://docs.mongodb.org/manual/reference/configuration-options/
# where to write logging data.
systemLog:
  destination: file
  logAppend: true
  path: /var/log/mongodb/mongod.log
# Where and how to store data.
storage:
  dbPath: /var/lib/mongo
  journal:
    enabled: true
#  engine:
#  mmapv1:
#  wiredTiger:
# how the process runs
processManagement:
  fork: true  # fork and run in background
  pidFilePath: /var/run/mongodb/mongod.pid  # location of pidfile
  timeZoneInfo: /usr/share/zoneinfo
# network interfaces
net:
  port: 27017
  bindIpAll: true
#security:
#operationProfiling:
#replication:
#sharding:
## Enterprise-Only Options
#auditLog:
#snmp:
EOF

    sudo yum install -y mongodb-org
    systemctl start mongod.service
    systemctl status mongod.service
    systemctl enable mongod.service
    systemctl is-enabled mongod.service
}


: "install active mq" && {
    wget https://archive.apache.org/dist/activemq/5.15.6/apache-activemq-5.15.6-bin.tar.gz
    sudo tar -zxvf apache-activemq-5.15.6-bin.tar.gz -C /opt
    sudo ln -s /opt/apache-activemq-5.15.6 /opt/activemq

    cat <<'EOF' > /usr/lib/systemd/system/activemq.service
[Unit]
Description=activemq message queue
After=network.target
[Service]
PIDFile=/opt/activemq/data/activemq.pid
ExecStart=/opt/activemq/bin/activemq start
ExecStop=/opt/activemq/bin/activemq stop
User=root
Group=root
[Install]
WantedBy=multi-user.target
EOF

    systemctl start activemq.service
    systemctl status activemq.service
    systemctl enable activemq.service
    systemctl is-enabled activemq.service
}

: "install redis" || {
    echo "install redis"
    yum install -y redis
    redis-server --version

}

systemctl is-enabled firewalld
systemctl is-enabled iptables
systemctl stop firewalld




