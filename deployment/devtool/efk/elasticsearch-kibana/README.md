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


