<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro de Aprendices</title>

    <style>
        body {
            font-family: Arial;
            background: #f4f4f4;
            margin: 40px;
        }

        .contenedor {
            width: 400px;
            margin: auto;
        }

        form {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            margin-top: 15px;
            padding: 10px;
            width: 100%;
            background: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background: #218838;
        }

        h2 {
            color: #333;
            text-align: center;
        }

        .mensaje-ok {
            color: green;
            text-align: center;
            margin-top: 15px;
            font-weight: bold;
        }

        .mensaje-error {
            color: red;
            text-align: center;
            margin-top: 15px;
            font-weight: bold;
        }
    </style>

</head>

<body>

<div class="contenedor">

    <h2>Registro de Aprendices</h2>

    <%-- Formulario HTML que envía los datos al Servlet mediante POST --%>
    <form action="registrar" method="post">

        <input
                type="text"
                name="nombre"
                placeholder="Nombre"
                required>

        <input
                type="text"
                name="apellido"
                placeholder="Apellido"
                required>

        <input
                type="email"
                name="correo"
                placeholder="Correo"
                required>

        <input
                type="text"
                name="telefono"
                placeholder="Teléfono"
                required>

        <button type="submit">
            Guardar
        </button>

    </form>

    <%-- Obtiene el parámetro enviado por el Servlet --%>
    <%
        String mensaje = request.getParameter("mensaje");

        // Muestra el mensaje cuando el registro fue exitoso.
        if ("ok".equals(mensaje)) {
    %>

    <div class="mensaje-ok">
        Registro guardado correctamente
    </div>

    <%
        }

        // Muestra el mensaje cuando ocurrió un error.
        if ("error".equals(mensaje)) {
    %>

    <div class="mensaje-error">
        Error al guardar el registro
    </div>

    <%
        }
    %>

</div>

</body>
</html>