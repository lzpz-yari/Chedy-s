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

| **Método** | **Propósito** |
|------------|---------------|
| `getInstance()` | Implementa el patrón Singleton para asegurar que solo una instancia de la clase `Conexion` sea creada. |
| `getConnection()` | Devuelve la conexión actual a la base de datos. |
| `reconnect()` | Cierra la conexión actual y la vuelve a abrir para reestablecer la conexión a la base de datos. |
| `close()` | Cierra la conexión a la base de datos si está abierta. |
| `insertarAdministrador()` | Inserta un nuevo administrador en la base de datos. |
| `actualizarAdministrador()` | Actualiza la información de un administrador existente. |
| `eliminarAdministrador()` | Elimina un administrador de la base de datos. |
| `obtenerAdministradores()` | Obtiene todos los administradores de la base de datos. |
| `buscarAdministradorPorID()` | Busca un administrador por su ID. |
| `insertarCajero()` | Inserta un nuevo cajero en la base de datos para agregarlo a la tabla `cajeros`. |
| `actualizarCajero()` | Actualiza la información de un cajero existente en la tabla `cajeros`. |
| `eliminarCajero()` | Elimina un cajero de la base de datos y lo quita de la tabla `cajeros`. |
| `obtenerCajeros()` | Obtiene todos los cajeros de la base de datos y recupera todos los registros de la tabla `cajeros`. |
| `buscarCajeroPorID()` | Busca un cajero específico por su ID en la tabla `cajeros`. |
| `actualizarCliente()` | Actualiza la información de un cliente existente en la tabla `cliente`. |
| `eliminarCliente()` | Elimina un cliente de la base de datos y lo quita de la tabla `cliente`. |
| `obtenerClientes()` | Obtiene todos los clientes de la base de datos y recupera todos los registros de la tabla `cliente`. |
| `buscarClientePorID()` | Busca un cliente específico por su ID en la tabla `cliente`. |
| `insertarDevolucion()` | Inserta una nueva devolución en la base de datos para agregarla a la tabla `devoluciones`. |
| `actualizarDevolucion()` | Actualiza la información de una devolución existente en la tabla `devoluciones`. |
| `eliminarDevolucion()` | Elimina una devolución de la base de datos y la quita de la tabla `devoluciones`. |
| `EntrarActionPerformed()` | Combina las verificaciones de correo y contraseña en una sola consulta SQL y gestiona la conexión de manera más eficiente. |
| `SalirActionPerformed()` | Maneja la acción de salir de la aplicación. |
| `validarIdCajero()` | Define una consulta SQL para contar los registros en la tabla `Cajeros` con el ID especificado. |
| `consultar()` | Consulta y muestra datos de la tabla `Zapato`. |
| `actualizarCampos()` | Actualiza los campos de texto con datos del zapato seleccionado por su ID de estilo. |
| `actualizarStock()` | Actualiza el stock de un zapato específico por modelo. |
| `devolverStock()` | Devuelve una cantidad específica de stock de un zapato por modelo. |
| `actualizarTotalPagar()` | Calcula el total a pagar sumando los valores de una columna específica en la tabla y lo muestra en un campo de texto. |
| `generarNotaDeVenta()` | Genera una nota de venta con los datos de la tabla, incluyendo fecha, email del cajero y detalles de los productos. |
| `generarPDF()` | Genera un archivo PDF con el contenido proporcionado. |
| `generarNombreUnico()` | Genera un nombre de archivo único añadiendo un contador al nombre base. |
| `enviarCorreo()` | Envía un correo electrónico con el archivo PDF adjunto. |
| `guardarNotaEnArchivo()` | Guarda una nota en un archivo de texto. |
| `insertarTransaccion()` | Inserta una transacción en la base de datos y retorna el ID generado. |
| `obtenerEmailCajero()` | Obtiene el correo electrónico de un cajero dado su ID. |
| `realizarCorteCaja()` | Realiza un corte de caja para una fecha específica, sumando las transacciones por forma de pago. |
| `cargarTransaccionesEnTabla()` | Carga las transacciones en una tabla desde la base de datos. |
| `realizarCorteCaja1()` | Similar al método `realizarCorteCaja`, con reconexión a la base de datos si es necesario. |
| `getNextTransactionId()` | Obtiene el próximo ID de transacción disponible. |
| `realizarDevolucion()` | Realiza una devolución de una transacción específica. |
| `verificarInventario()` | Verifica el inventario de zapatos y revisa sus cantidades. |
| `enviarAlerta()` | Envía una alerta de inventario bajo y ofrece reabastecer el producto. |
| `iniciarMonitoreoInventario()` | Inicia un monitoreo periódico del inventario cada minuto. |
| `generarReporteZapatosVendidos()` | Genera un reporte de los zapatos vendidos, ordenado por la cantidad vendida. |
| `reabastecerProducto()` | Reabastece el stock de un producto específico. |
| `cargarTransaccionesEnTablaPorFecha()` | Carga las transacciones en una tabla filtrando por fecha. |
| `buscarModelosMasVendidos()` | Busca los modelos más vendidos en un mes y año específicos. |
| `Verificar Selección()` | Comprueba si hay un empleado seleccionado en la tabla. |
| `Obtener Datos del Empleado()` | Recopila los datos del empleado seleccionado. |
| `Consultar Datos Adicionales()` | Realiza una consulta SQL para obtener información adicional (correo, salario, puesto) usando el RFC del empleado. |


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
1. Inicio de sesión como cajero o como administrador.
Dentro de la ventana de inicio, podemos visualizar dos apartados: uno para iniciar sesión como administrador y otro como cajero. Esto tiene como fin separar los roles independientes de cada uno. En ambos inicios de sesión, se solicita el correo y la contraseña única del usuario, además de ofrecer la opción de cerrar el sistema. En el inicio de sesión de un cajero, además de lo mencionado, hay un botón para recuperar la contraseña en caso de olvido o extravío, lo cual se realiza mediante una ventana emergente y el envío de la nueva contraseña al correo del cajero.

![inicio cajero](imagenes-readme/1.png) 

2. Pantalla de inicio de un cajero: función de generar ventas.
Dentro de esta ventana se visualizan los patrones de búsqueda, donde se puede buscar el producto solicitado de acuerdo a las especificaciones del cliente. Si se cumple con las especificaciones, el producto puede añadirse a la lista de compra del cliente. En la parte inferior se muestra el total a pagar, y se puede ingresar la cantidad de dinero proporcionada por el cliente para calcular el cambio, si es necesario. El ticket de compra se envía al correo electrónico del cliente si este así lo requiere.

![inicio cajero2](imagenes-readme/2.png) 

3.. Segundo panel de un cajero: generar un corte de caja de las ventas.
En la página del corte de caja se pueden calcular las ventas realizadas en un determinado periodo, visualizando por fecha para llevar un mejor control. Todo lo que se desea visualizar se muestra en una tabla, lo cual facilita el manejo de la información.

![cajero corte de caja](imagenes-readme/3.png) 

4.-Tercer panel: opción de generar una devolución.
En este panel se puede procesar la devolución de productos, añadiéndolos de nuevo a la base de datos. Para generar una devolución es importante tener el ticket de compra, por lo que es recomendable que el cliente lo solicite en caso de necesitar una devolución. Se requiere el número de ticket y la cantidad de artículos a devolver para eliminarlos del registro de ventas y añadir los productos nuevamente a la base de datos.

![devoluciones](imagenes-readme/4.png) 

5.- Visualización de productos vendidos en un periodo específico.
En este panel se pueden ver los productos más vendidos en la empresa, mostrando un top 10 de forma ordenada para visualizar las preferencias de los clientes. Además, se pueden ver estos datos por periodos, obteniendo información sobre las preferencias de los clientes según las temporadas.

![ventas zapatos](imagenes-readme/5.png) 

6.- Panel de inventario.
En este panel se pueden visualizar todos los productos, sus datos y características almacenadas en la base de datos. Se puede buscar productos utilizando diversas especificaciones, ya sea por código u otra característica, para tener un mejor orden y visualización del inventario. También se pueden ver los datos de los productos las veces que sea necesario.

![inventario](imagenes-readme/6.png) 

7.- Vista de inicio de sesión de un administrador y sus funciones.
En la vista principal de un administrador hay varios botones que dirigen a diversas funciones. Entre los principales se encuentran los botones de alta de empleados, modificación de empleados y credenciales de los cajeros. Los botones para agregar cajeros permiten seleccionar un empleado de la tabla de empleados para darle acceso al sistema como cajero, ya que no todos los empleados son cajeros.

![inicio admin](imagenes-readme/7.png) 

8.- Validación de campos para dar de alta a un empleado nuevo.
Los campos a rellenar son: nombre, apellido paterno, apellido materno, fecha de nacimiento (seleccionada mediante un botón con visualización de meses y años), correo, salario y puesto. La validación del campo RFC se realiza automáticamente según los datos proporcionados.

![validacion empleado](imagenes-readme/8.png) 

9.-Modificación de datos de un empleado existente.
Para modificar los datos de un empleado, primero se debe seleccionar al empleado en la ventana emergente. Los datos que se pueden modificar son: RFC, nombre, apellido paterno, apellido materno, correo, sueldo y puesto. Esta ventana no modifica nada sin que el usuario lo decida.

![modificacion](imagenes-readme/9.png) 

10.- Modificación de credenciales de un cajero.
Permite modificar las credenciales de un cajero o empleado para conocer cómo inicia sesión en el sistema. También se puede eliminar al cajero o empleado.

![credenciales](imagenes-readme/10.png) 

11.- Visualización del inventario y gestión de productos.
En este panel se puede dar de alta un nuevo producto o eliminarlo de la base de datos en caso de inexistencia, por ejemplo, si no se ha recibido un nuevo lote en un tiempo determinado. También se pueden obtener datos de diversos proveedores, visualizar los lotes cargados en la base de datos y agregar nuevos proveedores o buscar los existentes para ver la relación con ellos.

![inventario admin](imagenes-readme/11.png) 


## video demostrativo 
https://youtu.be/ijwb3YIN12o 
## Elaboración
-Edith Esmeralda Pérez Martínez

-Luis Enrrique Pinto Zarate






