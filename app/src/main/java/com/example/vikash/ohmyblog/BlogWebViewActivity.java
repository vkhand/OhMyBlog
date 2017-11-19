package com.example.vikash.ohmyblog;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class BlogWebViewActivity extends AppCompatActivity {

    protected String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web_view);

        Intent intent = getIntent();
        Uri blogUri = intent.getData();

        mUrl = blogUri.toString();
        WebView webView = findViewById(R.id.webview);
        webView.loadUrl(mUrl);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_blog_web_view, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        if(itemId == R.id.action_share){
            sharePost();

        }
        return super.onOptionsItemSelected(item);
    }

    private void sharePost() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mUrl);
        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_chooser_title)));
    }
}
