# trip API

## Microservicio desarrollado para el Diplomado "Desarrollo y despliegue de aplicaciones Cloud Native en ambientes híbridos" como parte del proyeco final. 

### La idea del proyecto final del diplomado es desarrollar un gestor de gastos de viaje (Travel Expense Manager) que permita registrar viajes y los gastos diarios realizados en cada uno, a fin de tener una forma confiable de dar seguimiento y gestionar gastos, ya sean vacaciones, viajes de trabajo, de negocios, etc. 


### Este microservicio tiene como propósito la gestión (CRUD) únicamente de los viajes realizados y sus caracteristicas. Está desarrollado en el lenguaje de programación Java, utilizando el framework de Spring y la base de datos MongoDB (Atlas) para la capa de persistencia. 

## Estrategia de branches (ramas) para un proyecto con seis desarrolladores - Práctica 1, Módulo 5

### De acuerdo a lo revisado en las sesiones del módulo, se determina que la mejor estrategia consideraría los siguientes puntos: 

1. Como prerequisito, la estructura del proyecto en Git y Github debe tener a "trunk" o branch "main" que es lo que está operando en el ambiente productivo
2. A partir de trunk (main), se genera el branch "dev" para el desarrollo de nuevas funcionalidades. 
3. A partir del branch "dev" se pueden crear las branch por cada nueva funcionalidad que será desarrollada o, en su defecto, si así lo considera el líder del proyecto, un branch para cada desarrollador. Como buena práctica de desarrollo de software, se sugiere crear un branch por cada nueva funcionalidad, utilizando la nomenclatura "feature_AAA". 

## Mensaje prueba del ejercicio 9 - Tekton event listener 
## Mensaje prueba del ejercicio 9 - Tekton event listener - prueba 2
## Mensaje prueba del ejercicio 9 - Tekton event listener - prueba 3

## > Verificación de mi CI/CD desde mi repositorio hugoemiliojara7/DCN_ProyectoFinal_HEJR_tripAPI

# Documentación proyecto final

## Continuos Integration - Integración continua 

De acuerdo a los temas revisados durante el módulo 5, la integración continua se define como una pŕactica del desarrollo de software que tiene como proósito realizar la intgeración de cambios en el código (correcciones, nuevas funcinalidades, pruebas, documentación, etc) de forma autmática, partiendo del control de cambios de un repositorio. 
La integración se entiende como el proceso de compilar y ejecutar un proyecto o servicio desarrollado. 

### La documentación y detalle del proceso de integración continua en este proyecto se encuentra en el archivo llamado "README-CI.md" ubicado en la carpeta "/manifest". 

## Continuos Delivery/Deployment - Entrega/Despliegue Continuo

La entrega/despliegue continuo, por otra parte, es un práctica del desarrollo de software que tiene como objetivo la producción de software en ciclos de despliegue cortos, asegurando que las nuevas funcionalidades o correcciones realizadas al proyecto o servicio pueden liberarse a un ambiente productivo de forma confiable y atuomatizada. 
Desde luego, esta práctica depende y va de la mano con el proceso de CI. 

### La documentación y detalle del proceso de entrega/despliegue continuo en este proyecto se encuentra en el archivo llamado "README-CD.md" ubicado en la carpeta "/manifest". 

