CREATE DATABASE IF NOT EXISTS lab9_productos;
USE lab9_productos;

CREATE TABLE IF NOT EXISTS usuario (
  id_usuario       INT AUTO_INCREMENT PRIMARY KEY,
  nombres          VARCHAR(80)  NOT NULL,
  apellidos        VARCHAR(80)  NOT NULL,
  email            VARCHAR(120) NOT NULL,
  password_hash    VARCHAR(255) NOT NULL,
  estado           ENUM('ACTIVO','BLOQUEADO') NOT NULL DEFAULT 'ACTIVO',
  UNIQUE KEY uk_usuario_email (email)
);

CREATE TABLE IF NOT EXISTS categoria (
  id_categoria   INT AUTO_INCREMENT PRIMARY KEY,
  nombre         VARCHAR(60) NOT NULL UNIQUE,
  descripcion    VARCHAR(200) NULL
);

CREATE TABLE IF NOT EXISTS producto (
  id_producto    INT AUTO_INCREMENT PRIMARY KEY,
  id_categoria   INT NOT NULL,
  nombre         VARCHAR(120) NOT NULL,
  descripcion    VARCHAR(400) NULL,
  precio         DECIMAL(10,2) NOT NULL CHECK (precio >= 0),
  stock          INT NOT NULL CHECK (stock >= 0),
  CONSTRAINT fk_producto_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
    ON UPDATE CASCADE ON DELETE RESTRICT,
  KEY idx_producto_categoria (id_categoria),
  KEY idx_producto_nombre (nombre)
);

CREATE TABLE IF NOT EXISTS carrito_item (
  id_item       INT AUTO_INCREMENT PRIMARY KEY,
  id_usuario    INT NOT NULL,
  id_producto   INT NOT NULL,
  cantidad      INT NOT NULL CHECK (cantidad > 0),
  agregado_en   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY uk_carrito_usuario_producto (id_usuario, id_producto),
  CONSTRAINT fk_carrito_usuario  FOREIGN KEY (id_usuario)  REFERENCES usuario(id_usuario)
    ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_carrito_producto FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
    ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO categoria (nombre, descripcion) VALUES
  ('Tecnología', 'Electrónica y computación'),
  ('Hogar',      'Artículos para el hogar'),
  ('Ropa',       'Vestimenta y accesorios');

INSERT INTO usuario (nombres, apellidos, email, password_hash, estado)
VALUES ('Admin', 'Demo', 'admin@demo.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'ACTIVO');

INSERT INTO producto (id_categoria, nombre, descripcion, precio, stock) VALUES
  ((SELECT id_categoria FROM categoria WHERE nombre='Tecnología'), 'Mouse Óptico', 'Mouse USB 1600 DPI', 39.90, 50),
  ((SELECT id_categoria FROM categoria WHERE nombre='Tecnología'), 'Teclado Mecánico', 'Switches táctiles', 199.00, 25),
  ((SELECT id_categoria FROM categoria WHERE nombre='Hogar'),      'Taza Cerámica', '350ml blanca', 15.00, 100),
  ((SELECT id_categoria FROM categoria WHERE nombre='Ropa'),       'Polera Unisex', 'Algodón, talla M', 79.00, 40);
