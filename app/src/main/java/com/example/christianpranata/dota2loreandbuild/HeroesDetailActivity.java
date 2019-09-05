package com.example.christianpranata.dota2loreandbuild;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class HeroesDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_LORE_NAME = "EXTRA_LORE_NAME";
    public static final String EXTRA_PHOTO = "EXTRA_PHOTO";
    public static final String EXTRA_ROLE = "EXTRA_ROLE";
    public static final String EXTRA_TYPE = "EXTRA_TYPE";
    public static final String EXTRA_COMPLEXITY = "EXTRA_COMPLEXITY";
    public static final String EXTRA_SET1 = "EXTRA_SET1";
    public static final String EXTRA_SET2 = "EXTRA_SET2";
    public static final String EXTRA_SET3 = "EXTRA_SET3";
    public static final String EXTRA_LORE = "EXTRA_LORE";
    public static final String EXTRA_SKILL = "EXTRA_SKILL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_hero);

        TextView tvHeroName = findViewById(R.id.tv_hero_name),
                tvHeroLoreName = findViewById(R.id.tv_hero_name_lore),
                tvHeroRole = findViewById(R.id.tv_hero_role),
                tvHeroType = findViewById(R.id.tv_hero_type),
                tvHeroComplexity = findViewById(R.id.tv_hero_complexity),
                tvHeroSkill = findViewById(R.id.tv_skill),
                tvLore = findViewById(R.id.tv_hero_lore);

        ImageView imgHeroPhoto = findViewById(R.id.img_hero_photo),
                imgHeroSet1 = findViewById(R.id.img_hero_set1),
                imgHeroSet2 = findViewById(R.id.img_hero_set2),
                imgHeroSet3 = findViewById(R.id.img_hero_set3);

        String hero_name = getIntent().getStringExtra(EXTRA_NAME),
                hero_role = getIntent().getStringExtra(EXTRA_ROLE),
                hero_lore = getIntent().getStringExtra(EXTRA_LORE),
                hero_type = getIntent().getStringExtra(EXTRA_TYPE),
                hero_complexity = getIntent().getStringExtra(EXTRA_COMPLEXITY),
                hero_skill = getIntent().getStringExtra(EXTRA_SKILL),
                hero_lore_name = getIntent().getStringExtra(EXTRA_LORE_NAME);

        String hero_photo = getIntent().getStringExtra(EXTRA_PHOTO),
                hero_set1 = getIntent().getStringExtra(EXTRA_SET1),
                hero_set2 = getIntent().getStringExtra(EXTRA_SET2),
                hero_set3 = getIntent().getStringExtra(EXTRA_SET3);

        tvHeroName.setText(hero_name);
        tvHeroLoreName.setText(hero_lore_name);
        tvHeroType.setText(hero_type);
        tvHeroRole.setText(hero_role);
        tvHeroSkill.setText(hero_skill);
        tvHeroComplexity.setText(hero_complexity);
        tvLore.setText(hero_lore);

        Glide.with(getApplicationContext())
                .load(hero_photo)
                .fitCenter()
                .into(imgHeroPhoto);
        Glide.with(getApplicationContext())
                .load(hero_set1)
                .fitCenter()
                .into(imgHeroSet1);
        Glide.with(getApplicationContext())
                .load(hero_set2)
                .fitCenter()
                .into(imgHeroSet2);
        Glide.with(getApplicationContext())
                .load(hero_set3)
                .fitCenter()
                .into(imgHeroSet3);

    }
}
