
wget https://dlcdn.apache.org/zookeeper/zookeeper-3.8.4/apache-zookeeper-3.8.4-bin.tar.gz

I have installed zookeeper in below location

/opt/apache-zookeeper-3.8.4-bin

go to that location and enter the below command

sudo ./bin/zkServer.sh start
===========================

Below command is to verify the zookeeper instance upo and running
bin/zkCli.sh -server localhost:2181

============================================================================================
This is the main resource URL we need to have high availability. It get all the product details and 
return only the product names

http://localhost:5050/product-names


============================================================================================


Each of the 3 instances(here we have used 3 microservices to demonstrate that) will return below response by below GET request

http://localhost:2020/products
http://localhost:3030/products
http://localhost:4040/products

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

===============================================================================================
http://localhost:2020/services
http://localhost:3030/services
http://localhost:4040/services
http://localhost:5050/services

All of the above GET requests will give the same response as below, showing the available services registered in zookeeper.
[
"test-service-B",
"test-service-A"
]


