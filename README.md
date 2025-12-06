# LAB9 IWEB - Sistema de Tienda

## Descripción del Proyecto
Sistema web de gestión de productos y carrito de compras desarrollado con Java Servlets y JSP.

## Funcionalidades Implementadas

1. **Navbar (Menú superior) e inicio de sesión:** 
Navbar visible en todas las páginas: título "Tienda – {nombre del usuario en sesión}" y dos ítems Productos y Carrito que redirigen a sus listas. Vista de inicio de sesión por defecto con correo y contraseña. La contraseña debe estar cifrada. La barra de navegación también debe incluir un botón para poder cerrar sesión. Nota: Si no se utilizan contraseñas con HASH se descontará puntaje.

2. **Implementar Creación y Listado de Producto:** 
 debe implementar el listado y la creación de productos. Para el listado usted debe implementar un DTO para cargar la lista que contenga los siguientes atributos: id, nombre, categoriaNombre, precio, stock (El stock de este DTO debe ser calculado como la resta del stock inicial - lo que hay actualmente en el carrito). Para la creación considerar colocarlo como un botón encima del listado e incluir los siguientes atributos: id_categoria, nombre, descripción, precio, stock. En cada fila de los productos, en la parte derecha, colocar un botón de añadir al carrito, no es necesario especificar cantidad (considerar 1 por defecto).

3. **Implementar Añadir al carrito y Listado de Productos :** 
Usted debe implementar el listado del carrito de compras. Implementar el botón de añadir al carrito en la vista de productos, al presionar este botón colocar 1 producto en el carrito como predeterminado. Para el listado del carrito usted debe implementar un DTO para cargar la lista que contenga los siguientes atributos: idItem, idProducto, nombreProducto, nombreUsuario, precioUnit, cantidad, subtotal (precio*cantidad).