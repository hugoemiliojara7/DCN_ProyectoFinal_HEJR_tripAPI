# Documentación Proyecto final - Integración Continua CI 

## Descripción de lo aprendido en Tekton para realizar el proceso de integración continua 

La integración continua se define como una pŕactica del desarrollo de software que tiene como proósito realizar la intgeración de cambios en el código (correcciones, nuevas funcinalidades, pruebas, documentación, etc) de forma autmática, partiendo del control de cambios de un repositorio.

De acuerdo al proceso definido en las sesiones del módulo, los pasos básicos para implementar la integración continua en un proyecto son los siguientes: 

    1. Clonar el repositorio 
    2. Realizar un "maven-build" con la nueva versión
    3. Subir (empujar) la nueva versión al registry de plataforma de contenedores (por ejemplo Docker)


Con estos tres pasos, estamos asegurando que los cambios que se realizan en nuestro código fuente, como el desarrollo de nuevas funcionalidades o la ocrrección de errores, se reflejan en nuestra plataforma de contenedores, lo cual nos permitirá realizar el despliegue de la nueva versión en el proceso de CD. 

Para implementar el CI en nuestro proyecto, se desarrollo una pipeline y una pipelinerun en Tekton que se ejecutan de forma automática cuando se detecta un cambio (commit o push) en la rama "master" del repositorio en la plataforma Github. 

## Prerequisitos y configuraciones previas 

A fin de llevar a cabo el proceso correctamente, es necesario configurar un webhook en el repositorio de GitHub, el cual notifica al event-listener configurado en el cluster de Kubernetes cuando ciertas acciones suceden. En este caso, las acciones son los "push" realizados a la rama "master". 

Adicionalmente, a fin de poder realizar el proceso correctamente, es necesario definir y crear los siguientes elemento en el cluster de Kubernetes en el cual se esté trabajando: 

    1. ServiceAccount: Cuenta de servicio con la cual se ejcutarán las acciones en el cluster. Este objeto se crea mediante el manifesto llamado "tekton-trigger-sa.yaml", el cual se encuentra en la ruta del repositorio manifest/tekton/triggers/
    2. RoleBinding: Elemento que vincula la cuenta de servicio creada con el event-listener que se ejecutará. Este objeto se crea mediante el manifiesto llamado "tekton-trigger-role-binding.yaml", el cual se encuentra en la ruta del repositorio manifest/tekton/triggers/
    3. TriggerTemplate: Plantilla con la estructura necesaria para ejecutar el pipeline. En esta se definen los parámetros necesarios, así como el nombre del pipeline a ejecutar y, de ser necesario, las credenciales de las cuentas asociadas (Docker registry). Este objeto se crea mediante el manifiesto llamado "tekton-trigger-template.yaml", el cual se encuentra en la ruta del repositorio manifest/tekton/triggers/
    4. TriggerBinding: Objeto que vincula el template creado y que contiene los valores de los parámetros definidos en la plantilla. Se define en el archivo "tekton-trigger-binding.yaml", el cual se encuentra en la siguiente ruta manifest/tekton/triggers/. 
    5. EventListener: El "escucha" de eventos. Es el objeto que realmente es notificado por el webhook cuando las acciones en el repositorio son realizadas. Este eventlistener es el encargado de "disparar" todas las acciones definidas en el pipeline, a partir de los "push realizados al repositorio. Se vincula con el trigger template y el trigger binding definidos anteriormente. Este objeto se define en el manifiesto "tekton-trigger-event-listener.yaml", ubicado en la ruta manifest/tekton/triggers/
    6. IngressService: Objeto que expone al exterior el eventlistener definido. Sin este service, el eventlistener no será capaz de detectar las acciones realizadas al repositorio. Se encuentra definido en el manifiesto "tekton-trigger-ingress-service.yaml", ubicado en la ruta manifest/tekton/triggers/. 

En cuanto se han creado y configurado correctamente, las pipeplines definidas se ejecutarán en cuanto el listener detecte la acción correcta en el repositorio de GitHub. 
Cabe mencionar que los nombres de los manifiestos .yaml en realidad no es relevante, siempre y cuando estén definidos correctamente. 

## Manifiestos para pipeline y pipelinerun con las tareas definidas 

Dentro de la carpeta del proyecto "../manifest/tekton/pipeline" se encuentran los siguientes manifiestos: 

    1. pipeline-ci.yaml: Manifiesto con la definición del pipeline. En este archivo se define la estructura y orden de los pasos del pipeline, así como los parámetros que recibe. Este archivo es el que tiene los tres pasos necesarios para la ejecución del proceso de CI, es decir, la obtenición de los cambios realizados al repositorio fuente (clonación del repositorio), construir la nueva versión (maven-build) y subir la nueva versión del proyecto/servicio al registry de contenedores, en este caso, Docker. 
    El nombre definido en este manifiesto es el que debe referenciarse en el manifiesto "trigger-template", a fin de que se ejecuten los pasos definidos en este pipeline. 
    2. pipelinerun-git-clone-package.yaml: Manifiesto que realmente ejecuta el pipeline definido. En este archivo se envían los valores de los parámetros a utilizar en la pipeline, como la URL del repositorio en GitHub, la imagen de maven con la que se debe construir el artefacto, el nombre de la nueva versión del proyecto/servicio y las credenciales necesarias. 

Al crearse estos elementos y ejecutarse de forma exitosa, se completa el proceso de integrción continua CI, ya que, en el momento en que se detectan cambios (push) a la rama definida (master, main, etc) en el repositorio de GitHub, el event-listener creado dispara el pipeline, que a su vez, ejecuta los tres pasos escenciales definidos al inicio de este documento. 

El proceso deo entrega/despliegue continuo contempla otra fase adicional, la cual se detalla en el archivo README-CD.md. 