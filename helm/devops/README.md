### ElasticSearch:
   helm upgrade --install elastic-release elastic-chart --namespace monitoring --create-namespace

### Kibana:
   helm upgrade --install kibana-release kibana-chart --namespace monitoring --create-namespace 
   Now for accessing elasticseaech and kibana, get the elastic user password using following command.
   kubectl get secret quickstart-es-elastic-user -n monitoring -o go-template='{{.data.elastic | base64decode}}'

### Fluentd: 
   Get the password of elastic user and update the fluent/values/yaml file in order to start the fluentd
   helm upgrade --install fluentd-release bitnami/fluentd -f fluentd\values.yaml

### Redis Cache
  helm upgrade --install redis-release redis-cache-service-chart --namespace redis --create-namespace
   ### To fix the READ_ONLY error kindly follow the following step.
   1. login to the all pod of redis using following command.
   2. kubectl exec -it pods/redis-0 -n redis sh
      Then fire the below command with user and pass
   3. redis-cli --user myredis --pass Redis@123 -h 127.0.0.1 -p 6379 slaveof no one
   4. exit
      That's it.
  
### Zipkin 
    helm upgrade --install zipkin-release zipkin-chart --namespace monitoring --create-namespace 


### Ingress Gateway
    helm upgrade --install ingress-release ingress-gateway-chart