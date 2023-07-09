package com.codingstuff.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;


import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;


import java.io.InputStream;

public class PDFActivity extends AppCompatActivity {

    private static final String TAG = "PDFActivity";

    PDFView pdfView;
    Integer page =0;
    InputStream inputStream = null;
    //url of our PDF file.
    //String pdfurl="https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
    String pdfurl ="https://drive.google.com/uc?export=download&id=1IefNXHuii14gLX4D4YGznqnoqEfyOuia";

    TextView nameTV, pagenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        //initializing our pdf view.
        pdfView = findViewById(R.id.idPDFView);
        nameTV = findViewById(R.id.name);
        Intent intent= getIntent();
        String name = intent.getStringExtra("Bookname");
        page = Integer.valueOf(intent.getStringExtra("position"))*5;
        nameTV.setText(name.toUpperCase());

        pdfView.fromAsset("chainsawman1.pdf")
                .spacing(20)
                .defaultPage(page)
                .swipeHorizontal(true)
                .fitEachPage(true) // fit each page to the view, else smaller pages are scaled relative to largest page.
                .pageSnap(true)
                .pageFling(true).load();
    }

    private void toastMessage(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
    //create an async task class for loading pdf file from URL.


  /*  class RetrivePDFfromUrl extends AsyncTask<String, Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            //we are using inputstream for getting out PDF.

            try {
                URL url = new URL(strings[0]);
                // below is the step where we are creating our connection.
                HttpURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    //response is success.
                    //we are getting input stream from url and storing it in our variable.
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());

                }

            } catch (IOException e) {
                //this is the method to handle errors.
                e.printStackTrace();
                return null;
            }

            return inputStream;
        }



        @Override
        protected void onPostExecute(InputStream inputStream) {
            // after the execution of our async task we are loading our pdf in our pdf view.

            pdfView.fromStream(inputStream).defaultPage(page).swipeHorizontal(true)
            .load();
            Log.d(TAG, "showData: pagenumber: " + page);

        }


    }

   */
}