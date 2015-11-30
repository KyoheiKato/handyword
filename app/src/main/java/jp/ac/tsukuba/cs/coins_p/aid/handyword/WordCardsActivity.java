package jp.ac.tsukuba.cs.coins_p.aid.handyword;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.dummy.ChartFragment;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.dummy.DummyContent;

public class WordCardsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        ItemFragment.OnListFragmentInteractionListener,
        EditFragment.OnFragmentInteractionListener,
        SelectFragment.SelectFragmentCallback,
        QuizFragment.QuizFragmentCallback,
        AnswerFragment.AnswerFragmentCallback{

    private static final String WEAK = "weak";
    private static final String LEARNED = "learned";
    private static final String NOT_LEARNED = "not_learned";
    private static final String ALL = "all";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_cards);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
        public void onStart(){
        super.onStart();
        setFragment(R.id.container, ChartFragment.newInstance());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.word_cards, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_weak) {
            setFragment(R.id.container, SelectFragment.newInstance(WEAK));
        } else if (id == R.id.nav_learned){
            setFragment(R.id.container, SelectFragment.newInstance(LEARNED));
        } else if (id == R.id.nav_not_learned) {
            setFragment(R.id.container, SelectFragment.newInstance(NOT_LEARNED));
        } else if (id == R.id.nav_all) {
            setFragment(R.id.container, SelectFragment.newInstance(ALL));
        } else if (id == R.id.nav_chart) {
            setFragment(R.id.container, ChartFragment.newInstance());
        } else if (id == R.id.nav_add) {
            setFragment(R.id.container, EditFragment.newInstance());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item){
    }

    @Override
    public void onFragmentInteraction(){
    }

    @Override
    public void onQuizSelected(){
        setFragment(R.id.container, QuizFragment.newInstance());
    }

    @Override
    public void onWordCardsSelected(){
        setFragment(R.id.container, ItemFragment.newInstance(20));
    }

    @Override
    public void onAnswerButtonClicked(){
        setFragment(R.id.container, AnswerFragment.newInstance());
    }

    @Override
    public void onCorrectButtonClicked(){
        setFragment(R.id.container, QuizFragment.newInstance());
    }
    @Override
    public void onWrongButtonClicked(){
        setFragment(R.id.container, QuizFragment.newInstance());
    }

    public void setFragment(int id, Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(id, fragment)
                .commit();
    }



}
