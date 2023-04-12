public void realizarAsignacionAleatoria() {
    // Creamos una copia de la lista original para no modificarla
    List<T> elementosCopiados = new ArrayList<>(elementos);
    // Barajamos los elementos de forma aleatoria
    Collections.shuffle(elementosCopiados);
    String nombreArchivoBase = "archivoauditoria";
    String rutaArchivo;
    int numeroArchivo = 1;
    do {
        rutaArchivo = System.getProperty("user.home") + "/Documents/" + nombreArchivoBase + numeroArchivo + ".txt";
        numeroArchivo++;
    } while (new File(rutaArchivo).exists()); // Busca un número disponible para el nombre de archivo

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
        for (int i = 0; i < elementos.size(); i++) {
            T elementoActual = elementos.get(i);
            T elementoAsignado = null;
            do {
                // Seleccionar un elemento de forma aleatoria
                int indiceElementoAsignado = (i + 1) % elementos.size();
                elementoAsignado = elementosCopiados.get(indiceElementoAsignado);
                // Si el elemento asignado es igual al elemento actual, seleccionar otro elemento de forma aleatoria
            } while (elementoAsignado == elementoActual);
            String mensaje = "A " + elementoActual + " le corresponde " + elementoAsignado;
            writer.write(mensaje);
            writer.newLine();
        }
        // Cerrar el archivo después de escribir en él
        writer.close();
    } catch (IOException e) {
        System.out.println("Error al escribir en archivo de auditoria: " + e.getMessage());
    }
    System.out.println("\nEl archivo de auditoria se guardo en el directorio Documents con el nombre " + rutaArchivo);
}
