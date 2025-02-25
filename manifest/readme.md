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


El comando para aplicar el task de Tekton en Kubernetes es el siguiente: 

    kubectl create -f task-run-git-clone.yaml -n diploe2-hejr

En la siguiente imagen se observa la creación del task y su correcta ejecución. 


### Ejercicio 6 - list-dir 

Este ejercicio consistió en crear otro manifiesto con el fin de observar si el comando "git clone" del ejercicio previo se había realizado correctamente. 
En sentido estricto, este paso no es necesario en un "pipeline" de Tekton, ya que únicamente lista la estructura del repositorio en GitHub, sin embargo, es muy útil para corroborar que el git clone se realizó  correctamente. 

En la siguiente imagen se observa la definición del archivo .yaml, el cual se nombró como "task-run-list-dir.yaml": 

El comando para aplicar el task de Tekton en Kubernetes es el siguiente: 

    kubectl create -f task-run-list-dir.yaml -n diploe2-hejr

En la siguiente imagen se observa la creación del task y la impresión de la estructura del repositorio, lo cual indica que se "clonó" de Github correctamente: 


### Ejercicio 6 - maven build 

El siguiente ejercicio consistió en crear un manifiesto para ejecutar el "build" de la aplicación Java con Maven. 

Esto permite crear el ".jar" ejecutable de la aplicación del repositorio en cuestión, en este caso, la API desarrollada para el diplomado. 

En la siguiente imagen se observa la definición del archivo .yaml, el cual se nombró como "task-run-mvn.yaml": 

El comando para aplicar el task de Tekton en Kubernetes es el siguiente: 

    kubectl create -f task-run-mvn.yaml -n diploe2-hejr

En la siguiente imagen se observa la creación del task y la impresión del log: 


### Ejercicio 6 - build-push

Este ejercicio consiste en crear un manifiesto para subir los cambios realizados en el repositorio al hub de Docker. 

En la siguiente imagen se observa la definición del archivo .yaml, el cual se nombró como "task-run-buildah.yaml": 


El comando para aplicar el task de Tekton en Kubernetes es el siguiente: 

    kubectl create -f task-run-buildah.yaml -n diploe2-hejr

En la siguiente imagen se observa la creación del task y la impresión del log: 


### Notas sobre los ejercicios realizados 

Todos los ejercicios se realizaron en el branch del repositorio llamado "feature/git-clone-build", como se solicitó. En este branch se realizaron los commits correspondietes. 

Los manifiestos ".yaml" se encuentran en la carpeta "../tripAPI/manifest/", los primeros dos en la carpeta "tekton-git-clone" y los segundos en la carpeta "tekton-build". 
