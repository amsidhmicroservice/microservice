### For installing the helm chart of elasticsearch and Kibana we need to install ECK operator and CRDs
First add the helm.elastic.co repo to helm local repository
helm repo add elastic https://helm.elastic.co
Check with 
helm repo ls

helm upgrade --install elastic-operator elastic/eck-operator -n elastic-system --create-namespace
helm upgrade --install elastic-operator elastic/eck-operator-crds -n elastic-system --create-namespace --force

### ElasticSearch:
#Pull elasticsearch image with required version mentioned in values.yaml file
docker pull docker.elastic.co/elasticsearch/elasticsearch:6.8.23
helm upgrade --install elastic-release elastic-chart --namespace monitoring --create-namespace

### Kibana:
#Pull kibana image with required version mentioned in values.yaml file. Elastic and Kibana version must be same.
docker pull docker.elastic.co/kibana/kibana:6.8.23
   helm upgrade --install kibana-release kibana-chart --namespace monitoring --create-namespace 
   Now for accessing elasticsearch and kibana, get the elastic user password using following command.
   kubectl get secret quickstart-es-elastic-user -n monitoring -o go-template='{{.data.elastic | base64decode}}'

### Fluentd: 

   Get the password of elastic user and update the fluent/values/yaml file in order to start the fluentd
   helm upgrade --install fluentd-release fluentd
   OR
   docker pull fluent/fluent-kubernetes-daemonset:v1.14.5-debian-elasticsearch7-1.1
   helm upgrade --install fluentd-release fluentd-kubernetes --namespace monitoring --create-namespace 

### Redis Cache
docker pull redis:latest
  helm upgrade --install redis-release redis-cache-service-chart --namespace redis --create-namespace
   ### To fix the READ_ONLY error kindly follow the following step.
   1. login to the all pod of redis using following command.
   2. kubectl exec -it pods/redis-0 -n redis sh
      Then fire the below command with user and pass
   3. redis-cli --user myredis --pass Redis@123 -h 127.0.0.1 -p 6379 slaveof no one
   4. exit
      That's it.
  
### Zipkin 
docker pull openzipkin/zipkin:latest
    helm upgrade --install zipkin-release zipkin-chart --namespace monitoring --create-namespace 


### Ingress Gateway
    helm upgrade --install ingress-release ingress-gateway-chart