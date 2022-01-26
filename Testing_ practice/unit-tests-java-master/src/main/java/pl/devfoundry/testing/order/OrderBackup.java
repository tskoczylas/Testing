package pl.devfoundry.testing.order;

import java.io.*;

class OrderBackup {

private Writer writer;

    public Writer getWriter() {
        return writer;
    }

void createFile() throws FileNotFoundException {
        File file = new File("backup.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        writer = new BufferedWriter(outputStreamWriter);
}

void backUpOrder(Order order) throws IOException {
    if (order == null) throw new IllegalStateException("Empty order cannot be add to backup");
    else {
        writer.append(order.toString());
    }
}

    public void closeFile() throws IOException {
        writer.close();
    }
}
