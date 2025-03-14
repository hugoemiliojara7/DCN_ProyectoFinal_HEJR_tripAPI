# Práctica 2

## Descripción de lo aprendido en Tekton y los ejercicios realizados en el reporistorio del proyecto 

### Persistence Volume Claim - diploe2-hejr
Previo a realizar las partes del ejercicio 6, fue necesario crear un persistence volumen en mi namespace (diploe2-hejr) para evitar conflictos en el contesto de Kubernetes. 
Para este fin, se definió un archivo .yaml (manifiesto) el cual tiene el nombre "task-run-pvc.yaml" para crear el volume. 

El detalle del manifiesto se aprecia en la siguiente imagen: 

![Image](https://github.com/user-attachments/assets/126c5c91-675f-4efb-bba9-54f761084be7)


El comando para crear el recurso en Kubernetes es el siguiente: 

    kubectl apply -f task-run-pvc.yaml -n diploe2-hejr

En la siguiente imagen se aprecia que el PVC se creó en el namespace. 

![Image](https://github.com/user-attachments/assets/1372433d-7682-4930-84f2-571c4269868a) 

### Ejercicio 6 - git-clone

Este ejercicio consistió en aplicar el comando  "git clone" al repositorio del diplomando mediante un task de Tekton.
Para este propósito, se creo un archivo .yaml (manifiesto), el cual nombré "task-run-git-clone.yaml". 

En la siguiente imagen se observa el detalle del archivo .yaml. 

![Image](https://github.com/user-attachments/assets/bd0bf313-be8f-4a82-851d-be70d13638e5)

El comando para aplicar el task de Tekton en Kubernetes es el siguiente: 

    kubectl create -f task-run-git-clone.yaml -n diploe2-hejr

En la siguiente imagen se observa la creación del task y su correcta ejecución. 

![Image](https://github.com/user-attachments/assets/a5e4a0fa-8792-44bd-ada5-d41baab6214a)

### Ejercicio 6 - list-dir 

Este ejercicio consistió en crear otro manifiesto con el fin de observar si el comando "git clone" del ejercicio previo se había realizado correctamente. 
En sentido estricto, este paso no es necesario en un "pipeline" de Tekton, ya que únicamente lista la estructura del repositorio en GitHub, sin embargo, es muy útil para corroborar que el git clone se realizó  correctamente. 

En la siguiente imagen se observa la definición del archivo .yaml, el cual se nombró como "task-run-list-dir.yaml": 

El comando para aplicar el task de Tekton en Kubernetes es el siguiente: 

    kubectl create -f task-run-list-dir.yaml -n diploe2-hejr

En la siguiente imagen se observa la creación del task y la impresión de la estructura del repositorio, lo cual indica que se "clonó" de Github correctamente: 

![Image](https://github.com/user-attachments/assets/89d9c700-eed9-400f-834c-aba9012e7c47)



### Ejercicio 6 - maven build 

El siguiente ejercicio consistió en crear un manifiesto para ejecutar el "build" de la aplicación Java con Maven. 

Esto permite crear el ".jar" ejecutable de la aplicación del repositorio en cuestión, en este caso, la API desarrollada para el diplomado. 

En la siguiente imagen se observa la definición del archivo .yaml, el cual se nombró como "task-run-mvn.yaml": 

El comando para aplicar el task de Tekton en Kubernetes es el siguiente: 

    kubectl create -f task-run-mvn.yaml -n diploe2-hejr

En la siguiente imagen se observa la creación del task y la impresión del log: 

![Image](https://github.com/user-attachments/assets/079bc476-ae22-4182-a265-bd50438b7822)

### Ejercicio 6 - build-push

Este ejercicio consiste en crear un manifiesto para subir los cambios realizados en el repositorio al hub de Docker. 

En la siguiente imagen se observa la definición del archivo .yaml, el cual se nombró como "task-run-buildah.yaml": 


El comando para aplicar el task de Tekton en Kubernetes es el siguiente: 

    kubectl create -f task-run-buildah.yaml -n diploe2-hejr

En la siguiente imagen se observa la creación del task y la impresión del log: 

![Image](https://github.com/user-attachments/assets/ab145ebb-16ba-4efa-86ba-58310c602936)


![Image](https://github.com/user-attachments/assets/ce0a3a2b-9e41-4d4f-aa6f-698474fc315d) 

### Notas sobre los ejercicios realizados 

Todos los ejercicios se realizaron en el branch del repositorio llamado "feature/git-clone-build", como se solicitó. En este branch se realizaron los commits correspondietes. 

Los manifiestos ".yaml" se encuentran en la carpeta "../tripAPI/manifest/", los primeros dos en la carpeta "tekton-git-clone" y los segundos en la carpeta "tekton-build". 

## Laboratorio 3. Pipeline CI 

Esta práctica consistió en crear una pipeline con los tres pasos escenciales para el proceso CI, es decir, clonar un repositio de Github, realizar la compilación con maven-build y subir la nueva versión del servicio (imagen) al registry de contenedores, en este caso, Docker. 

Para esto, se generaron los siguientes manifiestos: 

    1. pipeline-ci.yaml: Definición del pipeline, con los pasos a seguir y los parámetros que debe recibir, además del orden de ejcución de cada task
    2. pipelinerun-ci.yaml: Definición de la task run que ejecuta el pipeline definido. 

Ambos archivos se encuentran en la carpeta manifest/tekton/pipelines/. 

Tras la correcta ejecución del task-run, tenemos la ejecución de tres pods que realizan los tres pasos, completando el proceso de CI al tener una nueva imagen en DockerRegistry. 
A partir de este punto, es posible definir manifiestos para realizar el proceso de despliegue de la nueva versión del servicio. 