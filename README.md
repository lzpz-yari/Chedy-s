# Gestión de Ventas de Zapatería

## Descripción

El sistema que se ha presentado se basa en la gestión de ventas de una zapatería mostrándonos una conexión entre los diferentes controladores, la sección de vista y su modelo a una base de datos que contiene las especificaciones del sistema.

De la siguiente forma, debemos entender que el sistema nos proporciona un inicio de sesión para identificarnos ya sea como un empleado de tipo cajero o como gerente, mostrando una visualización diferente según el puesto, ya que estos dos roles tienen funciones diferentes.

El sistema presentado tiene diversas funciones, las cuales incluyen:

- **Inicio de Sesión**: Identifica a los tipos de empleados.
  - **Cajero**: Un empleado cuya función principal es vender productos, revisar el inventario para saber si hay existencias, realizar un corte de caja para conocer las ventas del día, hacer devoluciones si es necesario y visualizar los proveedores en caso de necesitar contactar con ellos.
  - **Administrador**: Maneja los proveedores y empleados dentro de la base de datos, pudiendo agregar o eliminar empleados. En la pantalla principal del administrador, se puede visualizar a los empleados de la empresa y se pueden realizar funciones específicas como:
    - Visualizar el inventario para agregar nuevos productos o visualizar los datos de un proveedor.
    - Ver las credenciales de un empleado seleccionado, agregarlo como cajero para que tenga su propio inicio de sesión, modificar los datos del empleado o eliminarlo.

Recordemos que la función principal en la venta de algún producto requiere un sistema que venda y muestre lo vendido, por lo que se necesita un comprobante de venta. En caso de que el cliente lo requiera, el ticket puede ser enviado al correo electrónico proporcionado.

Todo sistema requiere una validación de inicio de sesión para los distintos empleados, por lo que en caso de perder u olvidar la contraseña, esta debe ser enviada al correo privado del empleado para que quede registrada y pueda ser recuperada en caso de error.

## Usos

Los usos de este sistema son específicos y concretos, ya que se ha definido directamente para una empresa de zapatería. Por el momento, su uso en distintos campos o su implementación en otra empresa puede verse afectado, requiriendo ciertas actualizaciones o modificaciones para garantizar la compatibilidad total del sistema con los requerimientos de una nueva empresa.
## Características y Funciones - 
**Gestión de Usuarios (CRUD)**: Crear, leer, actualizar y eliminar usuarios. - 
**Gestión de Productos (CRUD)**: Crear, leer, actualizar y eliminar productos. - 
**Conexión a Base de Datos**: Integración con una base de datos para almacenamiento y recuperación de datos. - 
**Generación de PDF**: Crear documentos PDF con información relevante. - 
**Envío de PDF a Correo Electrónico**: Enviar documentos PDF generados al correo electrónico del cliente.

|

## API del Sistema

| Componente              | Descripción                                                                                          |
|-------------------------|------------------------------------------------------------------------------------------------------|
| `JTabbedPane`           | Proporciona una interfaz de usuario con pestañas, donde cada pestaña puede contener un panel diferente con sus propios componentes. |
| `JPanel1`               | Muestra el inicio de sesión de un administrador.                                                      |
| `JPanel2`               | Muestra el inicio de sesión de un cajero.                                                             |
| `JTextField`            | Permite al usuario ingresar una sola línea de texto.                                                  |
| `JLabel`                | Introduce textos para identificar componentes.                                                        |
| `JPasswordField`        | El texto ingresado se muestra como caracteres de ocultación (por ejemplo, asteriscos '*').            |
| `JButton (Entrar)`      | Botón para realizar la acción de entrar a una cuenta.                                                 |
| `JButton (Salir)`       | Botón asociado a la función de cerrar la conexión con la base de datos.                               |
| `JCheckBox`             | Cambia el estado de los caracteres asociados al `JPasswordField` de contraseña.                       |
| `JButton (Recuperar Contraseña)` | Contiene un método que nos devuelve la contraseña almacenada en la base de datos.                    |
| `JLabel` (Logo)         | Usado como etiqueta para tener el logo de la empresa.                                                 |
| `btnCancelar (Exit)`    | Botón aplicado en las ventanas con el fin de salir de las ventanas y terminar las acciones del sistema. |
| `JPanel (Caja)`         | Ofrece la vista de cómo se generarán las ventas.                                                      |
| `JLabel` (Componentes)  | Etiquetas que nos muestran los nombres de los componentes.                                            |
| `JTextField` (Datos)    | Al introducir texto se guardará para evaluar métodos establecidos con esos datos.                     |
| `JScrollPane`           | Añade automáticamente barras de desplazamiento verticales y horizontales cuando el contenido excede el área visible. |
| `JTable`                | Agrega una tabla donde podremos visualizar datos de acuerdo a las consultas que se hagan a la base de datos. |
| `JButton (Añadir)`      | Botón con la función de agregar los datos guardados en los `JTextField`.                              |
| `JButton (Eliminar)`    | Botón con la función contraria del botón agregar, elimina algún producto ya agregado.                 |
| `JButton (Generar Venta)` | Botón con el método de darnos una vista de la venta que se ha generado, además de enviar el PDF del ticket a un correo. |
| `JDateChooser`          | Proporciona una interfaz visual que permite al usuario seleccionar una fecha desde un calendario desplegable. |
| `JMonthChooser`         | Permite seleccionar un mes específico.                                                               |
| `JYearChooser`          | Permite verificar un año en específico.                                                              |
| `JComboBox`             | Permite al usuario seleccionar una opción de una lista desplegable.                                  |
## Metodos



## Diagrama Entidad-Relacional
A continuación, se muestra el diagrama entidad-relacional que ilustra las tablas y relaciones del sistema:
![Diagrama Entidad-Relacional](imagenes-readme/entidad-relacion.png) 

### Tablas y Relaciones

#### Tabla: Empleados
| Columna             | Tipo            |
|---------------------|-----------------|
| RFC                 | VARCHAR(30)     |
| nombre              | VARCHAR(50)     |
| Apellido_Paterno    | VARCHAR(50)     |
| Apellido_materno    | VARCHAR(50)     |
| correo              | VARCHAR(100)    |
| salario             | DOUBLE          |
| Usuario             | VARCHAR(50)     |
| Puesto              | VARCHAR(50)     |
| FechaNacimiento     | VARCHAR(45)     |

#### Tabla: Zapato
| Columna             | Tipo            |
|---------------------|-----------------|
| Estilo              | INT PRIMARY KEY |
| Modelo              | VARCHAR(50)     |
| Marca               | VARCHAR(50)     |
| Color               | VARCHAR(50)     |
| Talla               | DOUBLE          |
| Cantidad            | INT             |
| precio              | DOUBLE          |
| Tipo                | VARCHAR(100)    |

#### Tabla: Cajeros
| Columna             | Tipo            |
|---------------------|-----------------|
| ID                  | INT PRIMARY KEY |
| Email               | VARCHAR(45)     |
| Contrasena          | VARCHAR(45)     |
| EmpleadoID          | VARCHAR(45)     |

#### Tabla: Administrador
| Columna             | Tipo            |
|---------------------|-----------------|
| ID                  | INT PRIMARY KEY |
| Email               | VARCHAR(45)     |
| Contrasena          | VARCHAR(45)     |

#### Tabla: Cliente
| Columna             | Tipo            |
|---------------------|-----------------|
| ID                  | INT PRIMARY KEY |
| nombre              | VARCHAR(50)     |
| Apellido_Paterno    | VARCHAR(50)     |
| Apellido_materno    | VARCHAR(50)     |
| Numero_Telefono     | VARCHAR(100)    |

#### Tabla: Devoluciones
| Columna             | Tipo            |
|---------------------|-----------------|
| id                  | INT PRIMARY KEY |
| id_transaccion      | INT             |
| modelo              | VARCHAR(250)    |
| Cantidad            | INT             |
| precio              | DOUBLE          |
| fecha_hora          | TIMESTAMP       |

#### Tabla: Proveedor
| Columna             | Tipo            |
|---------------------|-----------------|
| RFC                 | VARCHAR(30)     |
| Nombre              | VARCHAR(60)     |
| Apellido_Paterno    | VARCHAR(50)     |
| Apellido_materno    | VARCHAR(50)     |
| Numero_Telefono     | VARCHAR(20)     |
| Email               | VARCHAR(90)     |
| NumeroLote          | VARCHAR(20)     |
| Fecha               | VARCHAR(50)     |

### Funcionalidades Adicionales

| Funcionalidad                     | Descripción                                                                                 |
|-----------------------------------|---------------------------------------------------------------------------------------------|
| Administración de Empleados y Productos | Solo los empleados con tipo 'Administrador' pueden agregar nuevos empleados o productos. |
| Visualización del Inventario      | Todos los empleados pueden visualizar el inventario de productos (Zapato).                 |
| Vista del Corte de Caja           | Los empleados pueden ver el corte de caja, que muestra las ventas realizadas.              |

## uso.
1.- iniciar sesión como cajero o como administrador
![inicio cajero](imagenes-readme/1.png) 
2.- pantalla de inicio de un cajero, función de generar las ventas.
![inicio cajero2](imagenes-readme/2.png) 
3.- segundo panel de un cajero, donde se puede generar un corte de caja de las ventas
![cajero corte de caja](imagenes-readme/3.png) 
4.-tercer panel nos muestra la opción de generar una devolución para que se vuelva a agregar el producto devuelto a la base de datos.
![devoluciones](imagenes-readme/4.png) 
5.- cierto panel nos da la opción de visualizar los productos vendidos en un periodo de tiempo que según sea solicitado 
![ventas zapatos](imagenes-readme/5.png) 
6.- quinto panel se basa en el inventario por lo que podemos visualizar todos los productos, sus datos y características las cuales están almacenadas en la base de datos
![inventario](imagenes-readme/6.png) 
7.- vista del inicio de session de un administrador y sus diversas funciones.
![inicio admin](imagenes-readme/7.png) 
8.- validacion de campos para dar de alta a un empleado nuevo 
![validacion empleado](imagenes-readme/8.png) 
9.- modificacion de los datos de un cliente existente
![modificacion](imagenes-readme/9.png) 
10.- credenciales de un cajero por si se necesita modificar el inicio de un cajero o empleado
![credenciales](imagenes-readme/10.png) 
11.- visualizacion del inventario que nos puede conducir a dar de alta un nuevo producto o eliminarlo de la base de datos por inexistencia en caso de que no se hayan recibido un nuevo lote en un determinado tiempo o cuando de cero.
![inventario admin](imagenes-readme/11.png) 


## video demostrativo 
https://youtu.be/ijwb3YIN12o 







