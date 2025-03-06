# Documentación Proyecto final - Entrega/Despliegue Continuo CD 

## Descripción de lo aprendido en Tekton para realizar el proceso de entrega/despliegue continuo

La entrega/despliegu continuo se define como una pŕactica del desarrollo de software que tiene como propósito omo objetivo la producción de software en ciclos de despliegue cortos, asegurando que las nuevas funcionalidades o correcciones realizadas al proyecto o servicio pueden liberarse a un ambiente productivo de forma confiable y atuomatizada. 
En el contexto del proyecto del diplomado, el objetivo final del proceso de CD es ponder disponible el servicio desarrollado, es decir, crear un nuevo "deployment" en el cluster de Kubernetes a fin de que el servicio esté disponible para su utilización. 
Es importante mencionar que el proceso de CD conlleva menos pasos ya que su tarea es unicamente desplegar la nueva versión del servicio en el cluster, lo cual se logra con los siguientes pasos: 

    1. Eliminar el deployment anterior del servicio (un deployment creado con una versión anterior)
    2. Crear un nuevo deployment con la nueva versión (la nueva versión es la imagen en el registry de la plataforma de contenedores, en este caso, Docker)


## Prerequisitos y configuraciones previas 

Dado que el proceso de CD es dependiente y, a su vez, complementa el proceso de CI, los prerequisitos son los mismos descritos en el documento README-CI.md. 

## Manifiestos para taskrun 

Para este proceso, se definieron los siguientes manifiestos yaml: 

    1.  ServiceAccount: Se definió una cuenta de servicio, la cual ejecuta el taskrun que crea el nuevo deploy. Esta serviceAccount debe ser la misma que se utiliza en el proceso de CI. Este manifiesto se encuentra en la ruta del repositorio manifest/tekton/tekton-deploy, con el nombre "tekton-sa.yaml"
    2. task-run-deploy: Manifiesto con el cual se crea el nuevo deploy. Es de tipo "kubernates-actions" y tiene definido los pasos de eliminaci+ón del deployment existente del servicio (con una versión previa) y la creación del nuevo deploy, en el cual se especifico la imagen (versión) del servicio con el que se cuenta en el registry de la plataforma de contenedores (Docker). Este manifiesto se encuentra en la ruta del repositorio manifest/tekton/tekton-deploy, bajo el nombre "task-run-deploy.yaml". 


En cuanto se ejecuta correctamente esta task-run, ya se tendrá displonible la nueva versión el servicio (deploy) para ser utilizado y/o consumido. 
Con esto se completa el proceso CI/CD, desde la acción inicial de dar commit (push) a la rama principal del repositorio, la cual desencadena todos los pasos descritos en el README-CI, y en el presente documento. 

