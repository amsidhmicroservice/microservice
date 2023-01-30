###Install Elastic and Kibana using helm chart
https://phoenixnap.com/kb/elasticsearch-helm-chart

###Using ECK
Youtube video link -> https://www.youtube.com/watch?v=qjnT0pU0IRo
https://www.elastic.co/guide/en/cloud-on-k8s/2.5/k8s-deploy-kibana.html
https://www.elastic.co/guide/index.html#
1) Install crds  
 >> kubectl apply -f 1-crds.yaml
check now
 > kubectl get kibana
 > kubectl get elasticsearch
 > kubectl get apmserver
 etc...
 
2) Install operators 
>> kubectl apply -f 2-operator.yaml
> 
> 
3) Install 3-elasticsearch.yaml

> kubectl apply -f 3-elasticsearch.yaml
If you get image Init:ImagePullBackOff error then pull the image first and check the status of the pod. Delete/recreate the pod
For minikube -> minikube ssh docker pull imagename
For Dockerdesktop ->  docker pull imageName

To get the password of elastic user use following command
PASSWORD=$( kubectl get secret quickstart-es-elastic-user -n monitoring -o go-template='{{.data.elastic | base64decode}}')

kubectl port-forward service/quickstart-es-http -n monitoring 9200
curl -u "elastic:$PASSWORD" -k "https://localhost:9200"

4) Install Kibana
   kubectl apply -f 4-kibana.yaml

docker.elastic.co/elasticsearch/elasticsearch:6.8.23
docker.elastic.co/kibana/kibana:6.8.23