BEGIN;

CREATE TABLE IF NOT EXISTS empleados.admins (
    codigo integer NOT NULL DEFAULT nextval('empleados.codigo_empleados_seq' :: regclass),
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    contrasena character varying(150) COLLATE pg_catalog."default" NOT NULL,
    correo character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT admins_pkey PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS empleados.bodegueros (
    codigo integer NOT NULL DEFAULT nextval('empleados.codigo_empleados_seq' :: regclass),
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    contrasena character varying(150) COLLATE pg_catalog."default" NOT NULL,
    correo character varying(100) COLLATE pg_catalog."default" NOT NULL,
    codigo_bodega integer NOT NULL,
    CONSTRAINT bodegueros_pkey PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS empleados.cajeros (
    codigo integer NOT NULL DEFAULT nextval('empleados.codigo_empleados_seq' :: regclass),
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    contrasena character varying(150) COLLATE pg_catalog."default" NOT NULL,
    correo character varying(100) COLLATE pg_catalog."default" NOT NULL,
    codigo_sucursal integer NOT NULL,
    codigo_caja integer NOT NULL,
    CONSTRAINT cajero_pkey PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS empleados.inventario (
    codigo integer NOT NULL DEFAULT nextval('empleados.codigo_empleados_seq' :: regclass),
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    contrasena character varying(150) COLLATE pg_catalog."default" NOT NULL,
    correo character varying(100) COLLATE pg_catalog."default" NOT NULL,
    codigo_sucursal integer NOT NULL,
    CONSTRAINT inventario_pkey PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS sucursales.bodegas (
    codigo serial NOT NULL,
    nombre character varying(300) COLLATE pg_catalog."default" NOT NULL,
    direccion character varying(400) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT bodegas_pkey PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS sucursales.bodegas_sucursal (
    codigo_bodega integer NOT NULL,
    codigo_sucursal integer NOT NULL
);

CREATE TABLE IF NOT EXISTS sucursales.catalogo_bodega (
    codigo_bodega integer NOT NULL,
    codigo_producto bigint NOT NULL,
    existencias integer NOT NULL
);

CREATE TABLE IF NOT EXISTS sucursales.catalogo_sucursal (
    codigo_sucursal integer,
    codigo_producto bigint,
    precio double precision,
    existencias integer,
    pasillo character varying(20) COLLATE pg_catalog."default"
);

CREATE TABLE IF NOT EXISTS sucursales.sucursal (
    codigo serial NOT NULL,
    nombre character varying(200) COLLATE pg_catalog."default" NOT NULL,
    direccion character varying(400) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT sucursal_pkey PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS ventas.clientes (
    nit bigint NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    correo character varying(100) COLLATE pg_catalog."default",
    direccion character varying(200) COLLATE pg_catalog."default",
    CONSTRAINT clientes_pkey PRIMARY KEY (nit)
);

CREATE TABLE IF NOT EXISTS ventas.detalles_factura (
    codigo_factura bigint NOT NULL,
    codigo_producto bigint NOT NULL,
    unidades integer NOT NULL,
    precio double precision NOT NULL
);

CREATE TABLE IF NOT EXISTS ventas.facturas (
    codigo bigserial NOT NULL,
    nit_cliente bigint NOT NULL,
    codigo_cajero integer NOT NULL,
    fecha date NOT NULL,
    total double precision NOT NULL,
    CONSTRAINT facturas_pkey PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS ventas.tarjetas (
    nit_cliente bigint NOT NULL,
    total_gastado double precision,
    puntos integer,
    tipo character varying(15) COLLATE pg_catalog."default" NOT NULL,
    fecha_creacion date NOT NULL
);

ALTER TABLE
    IF EXISTS empleados.bodegueros
ADD
    CONSTRAINT fk_codigo_bodega FOREIGN KEY (codigo_bodega) REFERENCES sucursales.bodegas (codigo) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE NO ACTION NOT VALID;

ALTER TABLE
    IF EXISTS empleados.cajeros
ADD
    CONSTRAINT fk_codigo_sucursal FOREIGN KEY (codigo_sucursal) REFERENCES sucursales.sucursal (codigo) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT NOT VALID;

ALTER TABLE
    IF EXISTS empleados.inventario
ADD
    CONSTRAINT fk_codigo_sucursal FOREIGN KEY (codigo_sucursal) REFERENCES sucursales.sucursal (codigo) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT NOT VALID;

ALTER TABLE
    IF EXISTS sucursales.bodegas_sucursal
ADD
    CONSTRAINT fk_codigo_bodega FOREIGN KEY (codigo_bodega) REFERENCES sucursales.bodegas (codigo) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE
    IF EXISTS sucursales.bodegas_sucursal
ADD
    CONSTRAINT fk_codigo_sucursal FOREIGN KEY (codigo_sucursal) REFERENCES sucursales.sucursal (codigo) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE
    IF EXISTS sucursales.catalogo_bodega
ADD
    CONSTRAINT fk_codigo_bodega FOREIGN KEY (codigo_bodega) REFERENCES sucursales.bodegas (codigo) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE
    IF EXISTS sucursales.catalogo_bodega
ADD
    CONSTRAINT fk_codigo_producto FOREIGN KEY (codigo_producto) REFERENCES productos.producto (codigo) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE
    IF EXISTS sucursales.catalogo_sucursal
ADD
    CONSTRAINT fk_codigo_producto FOREIGN KEY (codigo_producto) REFERENCES productos.producto (codigo) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE
    IF EXISTS sucursales.catalogo_sucursal
ADD
    CONSTRAINT fk_codigo_sucursal FOREIGN KEY (codigo_sucursal) REFERENCES sucursales.sucursal (codigo) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE
    IF EXISTS ventas.detalles_factura
ADD
    CONSTRAINT fk_codigo_factura FOREIGN KEY (codigo_factura) REFERENCES ventas.facturas (codigo) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE
    IF EXISTS ventas.detalles_factura
ADD
    CONSTRAINT fk_codigo_profucto FOREIGN KEY (codigo_producto) REFERENCES productos.producto (codigo) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE
    IF EXISTS ventas.facturas
ADD
    CONSTRAINT fk_codigo_cajero FOREIGN KEY (codigo_cajero) REFERENCES empleados.cajeros (codigo) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE
    IF EXISTS ventas.facturas
ADD
    CONSTRAINT fk_nit_cliente FOREIGN KEY (nit_cliente) REFERENCES ventas.clientes (nit) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE NO ACTION;

ALTER TABLE
    IF EXISTS ventas.tarjetas
ADD
    CONSTRAINT fk_nit_cliente FOREIGN KEY (nit_cliente) REFERENCES ventas.clientes (nit) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT;

END;

CREATE
OR REPLACE FUNCTION procesar_factura(
    _nit_cliente INT,
    _codigo_cajero INT,
    _puntos_a_usar INT,
    _productos INT [],
    _unidades INT [],
    _codigo_sucursal INT
) RETURNS VOID AS $ $ DECLARE nueva_factura_id INT;

descuento NUMERIC := 0;

_total NUMERIC := 0;

precio_producto NUMERIC;

unidades_producto INT;

BEGIN -- Verificar si el cliente tiene puntos suficientes, si aplica
IF _nit_cliente > 0
AND _puntos_a_usar > 0 THEN -- Verificar puntos del cliente y calcular descuento
SELECT
    ventas.verificar_puntos(_nit_cliente, _puntos_a_usar) INTO descuento;

END IF;

-- Insertar la factura (sin el total por ahora)
INSERT INTO
    ventas.facturas (nit_cliente, codigo_cajero, fecha, total)
VALUES
    (_nit_cliente, _codigo_cajero, CURRENT_DATE, 0) RETURNING codigo INTO nueva_factura_id;

-- Iterar sobre los productos para verificar existencias y calcular el total
FOR i IN 1..array_length(_productos, 1) LOOP -- Obtener el codigo de producto y cantidad
unidades_producto := _unidades [i];

-- Obtener el precio del producto en la sucursal
SELECT
    precio INTO precio_producto
FROM
    sucursales.catalogo_sucursal
WHERE
    codigo_producto = _productos [i]
    AND codigo_sucursal = _codigo_sucursal;

-- Insertar el producto en detalles_factura
INSERT INTO
    ventas.detalles_factura (
        codigo_factura,
        codigo_producto,
        unidades,
        precio
    )
VALUES
    (
        nueva_factura_id,
        _productos [i],
        unidades_producto,
        precio_producto
    );

-- Calcular el total acumulado
_total := _total + (precio_producto * unidades_producto);

END LOOP;

-- Aplicar el descuento si el cliente usó puntos
_total := _total - descuento;

-- Actualizar el total de la factura
UPDATE
    ventas.facturas
SET
    total = _total
WHERE
    codigo = nueva_factura_id;

-- Si se usaron puntos, descontarlos del cliente
IF _nit_cliente > 0
AND _puntos_a_usar > 0 THEN
UPDATE
    ventas.tarjetas
SET
    puntos = puntos - _puntos_a_usar
WHERE
    nit_cliente = _nit_cliente;

END IF;

END;

$ $ LANGUAGE plpgsql;

TRIGER PARA RESTAR LAS EXISTENCIAS CREATE FUNCTION ventas.restar_existencias_producto_sucursal() RETURNS TRIGGER AS $ $ DECLARE _codigo_sucursal INT;

BEGIN --jalamos el codigo de la sucursal mediante el codigo de la factura
SELECT
    cajeros.codigo_sucursal INTO _codigo_sucursal
FROM
    ventas.facturas
    INNER JOIN empleados.cajeros ON facturas.codigo_cajero = cajeros.codigo
WHERE
    facturas.codigo = new.codigo_factura;

UPDATE
    sucursales.catalogo_sucursal
SET
    existencias = existencias - new.unidades_producto
WHERE
    codigo_producto = new.codigo_producto
    AND codigo_sucursal = _codigo_sucursal;

RETURN NEW;

END;

$ $ LANGUAGE plpgsql;

CREATE TRIGGER tr_restar_existencias_productos_sucursal
AFTER
INSERT
    ON ventas.detalles_factura FOR EACH ROW EXECUTE FUNCTION ventas.restar_existencias_producto_sucursal();

CREATE FUNCTION ventas.verificar_existencias_sucursal() RETURNS TRIGGER AS $ $ DECLARE _codigo_sucursal INT;

existencias_producto INT;

BEGIN --jalamos el codigo de la sucursal mediante el codigo de la factura
SELECT
    cajeros.codigo_sucursal INTO _codigo_sucursal
FROM
    ventas.facturas
    INNER JOIN empleados.cajeros ON facturas.codigo_cajero = cajeros.codigo
WHERE
    facturas.codigo = new.codigo_factura;

-- Verificar existencias del producto en el catálogo de la sucursal
SELECT
    existencias INTO existencias_producto
FROM
    sucursales.catalogo_sucursal
WHERE
    codigo_producto = new.codigo_producto
    AND codigo_sucursal = _codigo_sucursal;

IF existencias_producto IS NULL
OR existencias_producto < new.unidades THEN RAISE EXCEPTION 'No hay suficientes existencias para el producto %',
new.codigo_producto;

END IF;

RETURN NEW;

END;

$ $ LANGUAGE plpgsql;

CREATE TRIGGER tr_verificar_existencias_sucursal BEFORE
INSERT
    ON detalles_factura FOR EACH ROW EXECUTE FUNCTION ventas.verificar_existencias_sucursal;

--COMO SE INGRESA DESDE EL BACKEND 
--procesar_factura(nit_cliente, codigo_cajero, puntos_a_usar, listaProductos, ListaUnidades, codigo_sucursal);								
SELECT
    ventas.procesar_factura(1, 2, 0, ARRAY [1, 2, 3], ARRAY [1, 1, 1], 1);

CREATE FUNCTION empleados.crear_empleados(
    tipo_usuario TEXT,
    nombre TEXT,
    usuario TEXT,
    contrasena TEXT,
    correo TEXT,
    codigo_bodega INT DEFAULT NULL,
    codigo_sucursal INT DEFAULT NULL,
    codigo_caja INT DEFAULT NULL
) RETURNS INT AS $ $ DECLARE nuevo_codigo INT;

BEGIN IF tipo_usuario = 'admin' THEN
INSERT INTO
    admins (codigo, nombre, usuario, contrasena, correo)
VALUES
    (
        nuevo_codigo,
        nombre,
        usuario,
        contrasena,
        correo
    ) RETURNING codigo INTO nuevo_codigo;

ELSIF tipo_usuario = 'bodeguero' THEN
INSERT INTO
    bodegueros (
        codigo,
        nombre,
        usuario,
        contrasena,
        correo,
        codigo_bodega
    )
VALUES
    (
        nuevo_codigo,
        nombre,
        usuario,
        contrasena,
        correo,
        codigo_bodega
    ) RETURNING codigo INTO nuevo_codigo;

ELSIF tipo_usuario = 'cajero' THEN
INSERT INTO
    cajeros (
        codigo,
        nombre,
        usuario,
        contrasena,
        correo,
        codigo_sucursal,
        codigo_caja
    )
VALUES
    (
        nuevo_codigo,
        nombre,
        usuario,
        contrasena,
        correo,
        codigo_sucursal,
        codigo_caja
    ) RETURNING codigo INTO nuevo_codigo;

ELSIF tipo_usuario = 'inventario' THEN
INSERT INTO
    inventarios (
        codigo,
        nombre,
        usuario,
        contrasena,
        codigo_sucursal
    )
VALUES
    (
        nuevo_codigo,
        nombre,
        usuario,
        contrasena,
        codigo_sucursal
    ) RETURNING codigo INTO nuevo_codigo;

ELSE RAISE EXCEPTION 'Tipo de usuario no válido';

END IF;

-- Devolver el código del nuevo usuario
RETURN nuevo_codigo;

END;

$ $ LANGUAGE plpgsql;

CREATE FUNCTION sucursales.ingresar_productos_bodega(
    _codigo_bodega INT,
    _codigos_productos INT [],
    _cantidades INT []
) RETURNS VOID AS $ $ DECLARE i INT;

_codigo_producto INT;

_cantidad INT;

BEGIN FOR i IN array_lower(_codigos_productos, 1)..array_upper(_codigos_productos, 1) LOOP _codigo_producto := _codigos_productos [i];

_cantidad := _cantidades [i];

-- Verificar si el producto ya existe en el catalogo de la bodega
IF EXISTS (
    SELECT
        1
    FROM
        catalogo_bodega
    WHERE
        codigo_bodega = _codigo_bodega
        AND codigo_producto = _codigo_producto
) THEN -- Si existe tons actualizar sumando la cantidad a las existencias
UPDATE
    catalogo_bodega
SET
    existencias = existencias + _cantidad
WHERE
    codigo_bodega = _codigo_bodega
    AND codigo_producto = _codigo_producto;

ELSE -- Si no existe, insertar un nuevo registro
INSERT INTO
    catalogo_bodega (codigo_bodega, codigo_producto, existencias)
VALUES
    (_codigo_bodega, _codigo_producto, _cantidad);

END IF;

END LOOP;

END;

$ $ LANGUAGE plpgsql;

CREATE FUNCTION sucursales.ingresar_productos_Sucursal (
    _codigo_bodega INT,
    _codigos_productos INT [],
    _cantidades INT []
) RETURNS VOID AS $ $ DECLARE i INT;

_codigo_sucursal INT;

_codigo_producto INT;

_cantidad INT;

BEGIN
SELECT
    codigo_sucursal INTO _codigo_sucursal
FROM
    sucursales.bodegas_sucursal
WHERE
    codigo_bodega = _codigo_bodega;

FOR i IN array_lower(_codigos_productos, 1)..array_upper(_codigos_productos, 1) LOOP _codigo_producto := _codigos_productos [i];

_cantidad := _cantidades [i];

-- Verificar si el producto ya existe en el catalogo de la bodega
IF EXISTS (
    SELECT
        1
    FROM
        sucursales.catalogo_sucursal
    WHERE
        codigo_sucursal = _codigo_sucursal
        AND codigo_producto = _codigo_producto
) THEN -- Si existe tons actualizar sumando la cantidad a las existencias
UPDATE
    sucursales.catalogo_sucursal
SET
    existencias = existencias + _cantidad
WHERE
    codigo_sucursal = _codigo_sucursal
    AND codigo_producto = _codigo_producto;

ELSE -- Si no existe, insertar un nuevo registro
INSERT INTO
    sucursales.catalogo_sucursal (codigo_sucursal, codigo_producto, existencias)
VALUES
    (_codigo_bodega, _codigo_producto, _cantidad);

END IF;

END LOOP;

END;

$ $ LANGUAGE plpgsql;

CREATE FUNCTION ventas.verificar_puntos(
    nit_cliente INT,
    puntos_a_usar INT,
    OUT descuento INT
) RETURNS INT AS $ $ BEGIN --si el nit del cliente es 0, entonces no se aplica ningun descuento
--ya que es un CF
IF nit_cliente = 0 THEN descuento := 0;

RETURN;

END IF;

-- verificamos la cantidad de puntos del cliente 
SELECT
    puntos INTO descuento
FROM
    ventas.tarjetas
WHERE
    nit_cliente = nit_cliente;

IF descuento IS NULL THEN RAISE EXCEPTION 'El cliente no existe';

END IF;

IF descuento < puntos_a_usar THEN RAISE EXCEPTION 'El cliente no tiene suficientes puntos';

END IF;

-- descuento de Q1 por cada punto
descuento := puntos_a_usar;

END;

$ $ LANGUAGE plpgsql;

CREATE FUNCTION sucursales.verificar_existencias(
    codigo_prod INT,
    codigo_suc INT,
    unidades INT
) RETURNS BOOLEAN AS $ $ DECLARE existencias_producto INT;

BEGIN -- verificar las existencias d elos productos en el catalogo de la sucursal
SELECT
    existencias INTO existencias_producto
FROM
    sucursales.catalogo_sucursal
WHERE
    codigo_producto = codigo_prod
    AND codigo_sucursal = codigo_suc;

IF existencias_producto IS NULL
OR existencias_producto < unidades THEN RAISE EXCEPTION 'No hay suficientes existencias para el producto %',
codigo_producto;

END IF;

RETURN TRUE;

END;

$ $ LANGUAGE plpgsql;

CREATE FUNCTION ventas.procesar_factura(
    _nit_cliente INT,
    _codigo_cajero INT,
    _puntos_a_usar INT,
    _productos INT [],
    _unidades INT [],
    _codigo_sucursal INT
) RETURNS VOID AS $ $ DECLARE nueva_factura_id INT;

descuento NUMERIC := 0;

_total NUMERIC := 0;

precio_producto NUMERIC;

unidades_producto INT;

BEGIN -- Verificar si el cliente tiene puntos suficientes, si aplica
IF _nit_cliente > 0
AND _puntos_a_usar > 0 THEN -- Verificar puntos del cliente y calcular descuento
SELECT
    ventas.verificar_puntos(_nit_cliente, _puntos_a_usar) INTO descuento;

END IF;

-- Insertar la factura (sin el total por ahora)
INSERT INTO
    ventas.facturas (nit_cliente, codigo_cajero, fecha, total)
VALUES
    (_nit_cliente, _codigo_cajero, CURRENT_DATE, 0) RETURNING codigo INTO nueva_factura_id;

-- Iterar sobre los productos para verificar existencias y calcular el total
FOR i IN 1..array_length(_productos, 1) LOOP -- Obtener el codigo de producto y cantidad
unidades_producto := _unidades [i];

-- Obtener el precio del producto en la sucursal
SELECT
    precio INTO precio_producto
FROM
    sucursales.catalogo_sucursal
WHERE
    codigo_producto = _productos [i]
    AND codigo_sucursal = _codigo_sucursal;

-- Insertar el producto en detalles_factura
INSERT INTO
    ventas.detalles_factura (
        codigo_factura,
        codigo_producto,
        unidades,
        precio
    )
VALUES
    (
        nueva_factura_id,
        _productos [i],
        unidades_producto,
        precio_producto
    );

-- Calcular el total acumulado
_total := _total + (precio_producto * unidades_producto);

END LOOP;

-- Aplicar el descuento si el cliente usó puntos
_total := _total - descuento;

-- Actualizar el total de la factura
UPDATE
    ventas.facturas
SET
    total = _total
WHERE
    codigo = nueva_factura_id;

-- Si se usaron puntos, descontarlos del cliente
--y agregarle los puntos del total-descuento 
IF _nit_cliente > 0 THEN --si uso puntos tons que le quite sus puntos
IF _puntos_a_usar > 0 THEN
UPDATE
    ventas.tarjetas
SET
    puntos = puntos - _puntos_a_usar
WHERE
    nit_cliente = _nit_cliente;

END IF;

PERFORM ventas.agregar_puntos_cliente(_nit_cliente, _total);

--le sumamos lo gastado al cliente
UPDATE
    ventas.tarjetas
SET
    total_gastado = total_gastado + _total
WHERE
    nit_cliente = _nit_cliente;

END IF;

END;

$ $ LANGUAGE plpgsql;

CREATE
OR REPLACE FUNCTION sucursales.validar_existencias_bodega() RETURNS TRIGGER AS $ $ DECLARE _codigo_sucursal INT;

existencias_producto INT;

BEGIN --jalamos el codigo de la sucursal mediante el codigo de la factura
SELECT
    cajeros.codigo_sucursal INTO _codigo_sucursal
FROM
    ventas.facturas
    INNER JOIN empleados.cajeros ON facturas.codigo_cajero = cajeros.codigo
WHERE
    facturas.codigo = new.codigo_factura;

-- Verificar existencias del producto en el catálogo de la sucursal
SELECT
    existencias INTO existencias_producto
FROM
    sucursales.catalogo_sucursal
WHERE
    codigo_producto = new.codigo_producto
    AND codigo_sucursal = _codigo_sucursal;

IF existencias_producto IS NULL
OR existencias_producto < new.unidades THEN RAISE EXCEPTION 'No hay suficientes existencias para el producto %',
new.codigo_producto;

END IF;

RETURN NEW;

END;

$ $ LANGUAGE plpgsql;

CREATE TRIGGER tr_validar_existencias_bodega BEFORE
INSERT
    OR
UPDATE
    ON sucursales.catalogo_sucursal FOR EACH ROW EXECUTE FUNCTION sucursales.validar_existencias_bodega();

CREATE
OR REPLACE FUNCTION sucursales.actualizar_existencias_bodega() RETURNS TRIGGER AS $ $ DECLARE _diferencia INT;

_codigo_bodega INT;

BEGIN
SELECT
    codigo_bodega INTO _codigo_bodega
FROM
    sucursales.bodegas_sucursal
WHERE
    codigo_sucursal = NEW.codigo_sucursal;

IF _codigo_bodega IS NULL THEN RAISE EXCEPTION 'No existe una bodega vinculada a la sucursal %',
NEW.codigo_sucursal;

END IF;

IF TG_OP = 'UPDATE' THEN -- Si es una actualización, calcular la diferencia entre las existencias nuevas y las antiguas
_diferencia := NEW.existencias - OLD.existencias;

ELSE -- Si es una insercion usar el valor de las existencias como la diferencia inicial
_diferencia := NEW.existencias;

END IF;

-- Restar la diferencia de existencias en la bodega correspondiente
UPDATE
    sucursales.catalogo_bodega
SET
    existencias = existencias - _diferencia
WHERE
    codigo_bodega = _codigo_bodega
    AND codigo_producto = NEW.codigo_producto;

RETURN NEW;

END;

$ $ LANGUAGE plpgsql;

CREATE TRIGGER tr_actualizar_existencias_bodega
AFTER
INSERT
    OR
UPDATE
    ON sucursales.catalogo_sucursal FOR EACH ROW EXECUTE FUNCTION sucursales.actualizar_existencias_bodega();

CREATE
OR REPLACE FUNCTION ventas.verificar_actualizacion_tarjeta() RETURNS TRIGGER AS $ $ BEGIN IF NEW.tipo = 'comun'
AND NEW.total_gastado >= 10000 THEN NEW.total_gastado := 0;

NEW.tipo := 'oro';

ELSIF NEW.tipo = 'oro'
AND NEW.total_gastado >= 20000 THEN NEW.total_gastado := 0;

NEW.tipo := 'platino';

ELSIF NEW.tipo = 'platino'
AND NEW.total_gastado >= 30000 THEN NEW.total_gastado := 0;

NEW.tipo := 'diamante';

END IF;

RETURN NEW;

END;

$ $ LANGUAGE plpgsql;

CREATE TRIGGER tr_actualizacion_tarjeta
AFTER
UPDATE
    OF total_gastado ON tarjetas FOR EACH ROW EXECUTE FUNCTION ventas.verificar_actualizacion_tarjeta();

CREATE VIEW empleados.usuarios AS
SELECT
    admins.codigo,
    admins.nombre,
    admins.usuario,
    admins.correo,
    '-1' :: integer AS codigo_bodega,
    '-1' :: integer AS codigo_sucursal,
    '-1' :: integer AS codigo_caja,
    'admin' :: text AS tipo
FROM
    empleados.admins
UNION
ALL
SELECT
    bodegueros.codigo,
    bodegueros.nombre,
    bodegueros.usuario,
    bodegueros.correo,
    bodegueros.codigo_bodega,
    '-1' :: integer AS codigo_sucursal,
    '-1' :: integer AS codigo_caja,
    'bodeguero' :: text AS tipo
FROM
    empleados.bodegueros
UNION
ALL
SELECT
    cajeros.codigo,
    cajeros.nombre,
    cajeros.usuario,
    cajeros.correo,
    '-1' :: integer AS codigo_bodega,
    cajeros.codigo_sucursal,
    cajeros.codigo_caja,
    'cajero' :: text AS tipo
FROM
    empleados.cajeros
UNION
ALL
SELECT
    inventario.codigo,
    inventario.nombre,
    inventario.usuario,
    inventario.correo,
    '-1' :: integer AS codigo_bodega,
    inventario.codigo_sucursal,
    '-1' :: integer AS codigo_caja,
    'inventario' :: text AS tipo
FROM
    empleados.inventario;

CREATE VIEW empleados.top10_ventas_mas_grandes AS
SELECT
    f.codigo,
    f.nit_cliente,
    f.fecha,
    f.total,
    cl.nombre AS nombre_cliente,
    cl.direccion,
    cl.correo
FROM
    ventas.facturas f
    JOIN ventas.clientes cl ON f.nit_cliente = cl.nit
ORDER BY
    f.total DESC
LIMIT
    10;

CREATE VIEW empleados.top10_productos_mas_vendidos AS
SELECT
    p.codigo,
    p.nombre,
    p.descripcion,
    p.categoria,
    p.sub_categoria,
    p.plataforma,
    sum(df.unidades) AS total_unidades_vendidas
FROM
    ventas.detalles_factura df
    JOIN productos.producto p ON df.codigo_producto = p.codigo
GROUP BY
    p.codigo,
    p.nombre,
    p.descripcion,
    p.categoria,
    p.sub_categoria,
    p.plataforma
ORDER BY
    (sum(df.unidades)) DESC
LIMIT
    10;

CREATE VIEW empleados.top10_clientes_mas_gastones AS
SELECT
    c.nit,
    c.nombre AS nombre_cliente,
    c.direccion,
    c.correo,
    sum(f.total) AS total_gastado
FROM
    ventas.facturas f
    JOIN ventas.clientes c ON f.nit_cliente = c.nit
GROUP BY
    c.nit,
    c.nombre,
    c.direccion,
    c.correo
ORDER BY
    (sum(f.total)) DESC
LIMIT
    10;

CREATE VIEW empleados.top2_sucursales_que_mas_generan AS
SELECT
    s.codigo,
    s.nombre AS nombre_sucursal,
    s.direccion,
    sum(f.total) AS total_generado
FROM
    ventas.facturas f
    JOIN empleados.cajeros c ON f.codigo_cajero = c.codigo
    JOIN sucursales.sucursal s ON c.codigo_sucursal = s.codigo
GROUP BY
    s.codigo,
    s.nombre,
    s.direccion
ORDER BY
    (sum(f.total)) DESC
LIMIT
    2;

CREATE VIEW sucursales.productos_sucursal AS
SELECT
    catalogo_sucursal.codigo_sucursal,
    catalogo_sucursal.codigo_producto,
    catalogo_sucursal.precio,
    catalogo_sucursal.existencias,
    catalogo_sucursal.pasillo,
    producto.nombre,
    producto.descripcion,
    producto.categoria,
    producto.sub_categoria,
    producto.plataforma
FROM
    sucursales.catalogo_sucursal
    JOIN productos.producto ON catalogo_sucursal.codigo_producto = producto.codigo;

CREATE VIEW ventas.cliente_view AS
SELECT
    clientes.nit,
    clientes.nombre,
    clientes.correo,
    clientes.direccion,
    tarjetas.total_gastado,
    tarjetas.puntos,
    tarjetas.tipo,
    tarjetas.fecha_creacion
FROM
    ventas.clientes
    LEFT JOIN ventas.tarjetas ON clientes.nit = tarjetas.nit_cliente;

CREATE VIEW sucursales.productos_bodega AS
SELECT
    catalogo_bodega.codigo_bodega,
    catalogo_bodega.codigo_producto,
    catalogo_bodega.existencias,
    producto.nombre,
    producto.descripcion,
    producto.categoria,
    producto.sub_categoria,
    producto.plataforma
FROM
    sucursales.catalogo_bodega
    JOIN productos.producto ON catalogo_bodega.codigo_producto = producto.codigo;
    

END;