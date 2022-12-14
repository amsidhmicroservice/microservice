Install Apache Zookeeper using helm chart.

1) helm repo add bitnami https://charts.bitnami.com/bitnami
2) helm repo update
3) helm install zookeeper bitnami/zookeeper --set replicaCount=3 --set auth.enabled=false --set allowAnonymousLogin=true
4) edit the service -> kubectl edit service/zookeeper -o yaml and change type: LoadBalancer
5) Start accessing the service on local machine using localhost:2181
6)