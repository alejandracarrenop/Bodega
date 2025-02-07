package firebase;
import model.Producto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
/**
 * @author Alejandra Carreño P
 */
public class FirebaseSaveProducto {
    public static void SaveProducto(Producto x) {
        new FirebaseSaveProducto().save(x);
    }
   
    private FirebaseDatabase firebaseDatabase;

/**
* inicialización de firebase.
*/
    private void initFirebase() {
       
        try {
            FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()  
                    .setDatabaseUrl("https://bodega-bbd35-default-rtdb.firebaseio.com/")
                    //.setServiceAccount(new FileInputStream(new File("C:\\Users\\Lenovo\\Documents\\pc\\NetBeansProjects\\firebase\\prueba-esp-a7c2a-firebase-adminsdk-yd7qe-1bdb100458.json")))
                    .setServiceAccount(new FileInputStream(new File("C:\\Users\\Fredy Carreño\\Dropbox\\Archivos niñas Carreño Parra\\Tareas Alejandra\\2025\\Semestre 2\\Programación\\Bodega\\\\bodega-bbd35-firebase-adminsdk-fbsvc-70d80a33a2.json")))

                   // .setDatabaseUrl("https://ejemplo1-f971f-default-rtdb.firebaseio.com/")
                    //.setServiceAccount(new FileInputStream(new File("C:\Users\Estudiante\Downloads\ConjuntAPP\ejemplo1-f971f-default-rtdb-export.json")))
                    .build();

            FirebaseApp.initializeApp(firebaseOptions);
            firebaseDatabase = FirebaseDatabase.getInstance();
            System.out.println("Conexión exitosa....");
        }catch (RuntimeException ex) {
            System.out.println("Problema ejecucion ");
        }catch (FileNotFoundException ex) {
            System.out.println("Problema archivo");
        }

         
    }

    /**
     * Save item object in Firebase.
     * @param item
     */
    private void save(Producto producto) {
        if (producto != null) {
            initFirebase();
           
            /* Get database root reference */
            DatabaseReference databaseReference = firebaseDatabase.getReference("/");
           
            /* Get existing child or will be created new child. */
            DatabaseReference childReference = databaseReference.child("usuario");

            /**
             * The Firebase Java client uses daemon threads, meaning it will not prevent a process from exiting.
             * So we'll wait(countDownLatch.await()) until firebase saves record. Then decrement `countDownLatch` value
             * using `countDownLatch.countDown()` and application will continues its execution.
             */
            CountDownLatch countDownLatch = new CountDownLatch(1);
            childReference.setValue(producto, new DatabaseReference.CompletionListener() {

                @Override
                public void onComplete(DatabaseError de, DatabaseReference dr) {
                    System.out.println("Registro guardado!");
                    // decrement countDownLatch value and application will be continues its execution.
                    countDownLatch.countDown();
                }
            });
            try {
                //wait for firebase to saves record.
                countDownLatch.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void recover() {
       
            initFirebase();

            /* Get database root reference */
            DatabaseReference databaseReference = firebaseDatabase.getReference("producto");

            /* Get existing child or will be created new child. */
            //DatabaseReference childReference = databaseReference.child("item");

            /**
             * The Firebase Java client uses daemon threads, meaning it will not
             * prevent a process from exiting. So we'll
             * wait(countDownLatch.await()) until firebase saves record. Then
             * decrement `countDownLatch` value using
             * `countDownLatch.countDown()` and application will continues its
             * execution.
             */
            CountDownLatch countDownLatch = new CountDownLatch(1);
            databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        String value = dataSnapshot.getValue(String.class);
                        //System.out.println("valor: "+ value.getId());
                        System.out.println("valor: "+ value);

                        //System.out.println("valor: "+ value.getPrice());
                        //System.out.println("valor: "+ value.getName());
                        countDownLatch.countDown();

                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                       // Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
        try {
            //wait for firebase to saves record.
            countDownLatch.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

       
            }

    private void build() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}