package com.salesforce.telmex.utils;

import com.jayway.jsonpath.JsonPath;
import com.salesforce.telmex.models.Cuenta;
import com.salesforce.telmex.models.Producto;
import com.salesforce.telmex.models.SubProducto;
import com.salesforce.telmex.models.User;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;


public class JsonDataReader {

    private static final String JSON_USER_FILE_PATH = "dataSet/users.json";
    private static final String JSON_CUENTA_FILE_PATH = "dataSet/cuentas.json";
    private static final String JSON_PRODUCTO_FILE_PATH = "dataSet/productos.json";

    public static User getUserByRole(String rol) throws Exception {
        String jsonData = readJson(JSON_USER_FILE_PATH);

        // Obtenemos lista de usuarios que coincidan con el rol
        List<Map<String, Object>> usersMaps = JsonPath.read(jsonData, "$[0].users[?(@.rol=='" + rol + "')]");

        if (usersMaps.isEmpty()) {
            throw new IllegalArgumentException("Usuario con rol " + rol + " no encontrado");
        }

        // Convertir el primer Map en un objeto User
        Map<String, Object> userMap = usersMaps.get(0);
        return convertMapToUser(userMap);
    }

    public static Cuenta getCuentaByNivel(String nivel) throws Exception {
        String jsonData = readJson(JSON_CUENTA_FILE_PATH);

        // Obtenemos lista de usuarios que coincidan con el rol
        List<Map<String, Object>> cuentasMaps = JsonPath.read(jsonData, "$[0].cuentas[?(@.nivel=='" + nivel + "')]");

        if (cuentasMaps.isEmpty()) {
            throw new IllegalArgumentException("Cuenta con nivel " + nivel + " no encontrado");
        }

        // Convertir el primer Map en un objeto Cuenta
        Map<String, Object> cuentaMap = cuentasMaps.get(0);
        return convertMapToCuenta(cuentaMap);
    }

    public static Producto getProductoByNombre(String nombre) throws Exception {
        String jsonData = readJson(JSON_PRODUCTO_FILE_PATH);

        // Obtenemos lista de productos que coincidan con el nombre
        List<Map<String, Object>> productosMaps = JsonPath.read(jsonData, "$[0].productos[?(@.nombre=='" + nombre + "')]");

        if (productosMaps.isEmpty()) {
            throw new IllegalArgumentException("Producto con nombre " + nombre + " no encontrado");
        }

        // Convertir el primer Map en un objeto Cuenta
        Map<String, Object> productoMap = productosMaps.get(0);
        return convertMapToProducto(productoMap);
    }

    public static SubProducto getSubProductoByNombre(String productoPadre, String nombreSubproducto) throws Exception {
        String jsonData = readJson(JSON_PRODUCTO_FILE_PATH);

        // Buscar el producto padre por nombre
        List<Map<String, Object>> productosMaps = JsonPath.read(jsonData, "$[0].productos[?(@.nombre=='" + productoPadre + "')]");

        if (productosMaps.isEmpty()) {
            throw new IllegalArgumentException("Producto padre no encontrado: " + productoPadre);
        }

        Map<String, Object> productoMap = productosMaps.get(0);

        if (!productoMap.containsKey("subproductos")) {
            throw new IllegalArgumentException("El producto '" + productoPadre + "' no contiene subproductos.");
        }

        List<Map<String, Object>> subproductos = (List<Map<String, Object>>) productoMap.get("subproductos");

        for (Map<String, Object> subMap : subproductos) {
            if (subMap.get("nombre").toString().equalsIgnoreCase(nombreSubproducto)) {
                return convertMapToSubProductos(subMap);
            }
        }

        throw new IllegalArgumentException("Subproducto '" + nombreSubproducto + "' no encontrado en el producto '" + productoPadre + "'");
    }


    private static String readJson(String json) throws Exception {
        try (InputStream is = JsonDataReader.class.getClassLoader().getResourceAsStream(json)) {
            if (is == null) {
                throw new IllegalStateException("No se pudo encontrar el archivo de usuarios.");
            }
            return IOUtils.toString(is, StandardCharsets.UTF_8);
        }
    }

    // Metodo para convertir el Map a objeto usuario
    private static User convertMapToUser(Map<String, Object> userMap) {
        User user = new User();
        user.setUsername((String) userMap.get("username"));
        user.setPassword((String) userMap.get("password"));
        user.setRol((String) userMap.get("rol"));
        return user;
    }

    // Metodo para convertir el Map a objeto cuenta
    private static Cuenta convertMapToCuenta(Map<String, Object> cuentaMap) {
        Cuenta cuenta = new Cuenta();
        cuenta.setNombre((String) cuentaMap.get("nombre"));
        cuenta.setNivel((String) cuentaMap.get("nivel"));
        cuenta.setContacto((String) cuentaMap.get("contacto"));
        return cuenta;
    }

    // Metodo para convertir el Map a objeto producto
    private static Producto convertMapToProducto(Map<String, Object> cuentaMap) {
        Producto producto = new Producto();
        producto.setNombre((String) cuentaMap.get("nombre"));
        return producto;
    }

    // Metodo para convertir el Map a objeto Sub producto
    private static SubProducto convertMapToSubProductos(Map<String, Object> cuentaMap) {
        SubProducto subProducto = new SubProducto();
        subProducto.setNombre((String) cuentaMap.get("nombre"));
        subProducto.setPrecio_platino((String) cuentaMap.get("precio_platino"));
        subProducto.setPrecio_oro((String) cuentaMap.get("precio_oro"));
        subProducto.setPrecio_plata((String) cuentaMap.get("precio_plata"));
        return subProducto;
    }
}
