###Install Elastic and Kibana using helm chart
https://phoenixnap.com/kb/elasticsearch-helm-chart

###Using ECK
Youtube video link -> https://www.youtube.com/watch?v=qjnT0pU0IRo
https://www.elastic.co/guide/en/cloud-on-k8s/2.5/k8s-deploy-kibana.html
1) Install crds  
 >> kubectl apply -f crds
check now
 > kubectl get kibana
 > kubectl get elasticsearch
 > kubectl get apmserver
 etc...
 
2) Install operators 
>> kubectl apply -f operator.yaml
> 
> 


To get the password of elastic user use following command
PASSWORD=$(kubectl get secret quickstart-es-elastic-user -o go-template='{{.data.elastic | base64decode}}')

kubectl port-forward service/quickstart-es-http 9200
curl -u "elastic:$PASSWORD" -k "https://localhost:9200"