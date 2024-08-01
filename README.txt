
wget https://dlcdn.apache.org/zookeeper/zookeeper-3.8.4/apache-zookeeper-3.8.4-bin.tar.gz
sudo ./bin/zkServer.sh start


bin/zkCli.sh -server localhost:2181




http://localhost:5050/product-names




[
{
"id": 1,
"name": "product-A",
"serialNumber": "AAAAA",
"expiryDate": "2024-05-01T12:30:45"
},
{
"id": 2,
"name": "product-B",
"serialNumber": "BBBBB",
"expiryDate": "2024-05-01T12:30:45"
},
{
"id": 3,
"name": "product-C",
"serialNumber": "CCCCC",
"expiryDate": "2024-05-01T12:30:45"
}
]


