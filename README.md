# demo-kubernetes

Playing around with Kubernetes as a learning exercise.

Work in progress...

## Versions Tested with

- Java 11
- Docker 20.10.2 (Docker for Mac)
- kubectl v1.20.2
- minikube v1.17.1

## Local environment

Tested with minikube. Install: https://minikube.sigs.k8s.io/docs/start/

Used Docker for Mac for container runtime environment. Have Docker for Mac running, and then:

```bash
# To make docker the default driver:
minikube config set driver docker

# Start Kubernetes cluster - "default" is default namespace
minikube start
kubectl get namespaces

# Start Kubernetes dashboard
minikube dashboard

minikube stop
```

Would like to explore other local Kubernetes testing environments such as Kind.

## demo-api

- spring boot rest api app
- spotify maven plugin to deploy Docker to personal dockerhub https://hub.docker.com/repository/docker/yodood/demo-api

package and deploy to dockerhub:

```bash
mvn deploy
```

deploy to local Kubernetes cluster:

```bash
kubectl apply -f kubernetes/deployment.yaml
kubectl get pods

# Test
kubectl port-forward deploy/demo-api 8080:8080
# Go to http://localhost:8080 in browser - default Spring 404 pages shows
```




