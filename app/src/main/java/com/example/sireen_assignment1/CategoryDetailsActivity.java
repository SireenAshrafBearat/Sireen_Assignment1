package com.example.sireen_assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDetailsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> itemDetailsList = new ArrayList<>();
    private Map<String, String> itemDetailsMap = new HashMap<>(); // Map to store item details

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);

        // Initialize ListView
        listView = findViewById(R.id.list_view);

        // Display the selected category
        TextView tvCategory = findViewById(R.id.tv_category);
        ImageView ivCategoryImage = findViewById(R.id.iv_category_image);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("category")) {
            String category = intent.getStringExtra("category");
            tvCategory.setText(category);
            // Set image based on category
            if (category.equals("تركيب الجهاز البولي")) {
                ivCategoryImage.setImageResource(R.drawable.img1);
            } else if (category.equals("تركيب الوحدة الأنبوبية الكلوية")) {
                ivCategoryImage.setImageResource(R.drawable.img2);
            } else if (category.equals("خطوات تكوين البول")) {
                ivCategoryImage.setImageResource(R.drawable.img3);
            }
            // Populate the ListView with sample data based on the selected category
            populateItemDetails(category);
        }

        // Set click listener for ListView items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemName = itemDetailsList.get(position);
                // Start DetailsActivity and pass item details
                Intent detailsIntent = new Intent(CategoryDetailsActivity.this, DetailsActivity.class);
                detailsIntent.putExtra("name", itemName);
                detailsIntent.putExtra("details", itemDetailsMap.get(itemName)); // Pass the details as an extra
                startActivity(detailsIntent);
            }
        });
    }

    private void populateItemDetails(String category) {
        // Populate the list and map based on the selected category
        if (category.equals("تركيب الجهاز البولي")) {
            itemDetailsList.add("الكلية");
            itemDetailsList.add("الحالب");
            itemDetailsList.add("المثانة");

            // Populate item details
            itemDetailsMap.put("الكلية", "الكُلْية : هي عضو موجود في الفقاريات شبيه من حيث الشكل ببذرة الفاصوليا لونها بني مائل للحمرة، يبلغ طولها نحو 12 سم، وتعد الكلية العضو المسؤول عن تنقية وتصفية الدم من السموم ونواتج عملية الأيض، تستقبل الكلية الدم عبر الشرايين الكلوية ويخرج من الأوردة الكلوي  \n" +
                    "من الوظائف المهمة للكليتين تنظيف الدم. مع دوران الدم في أنحاء الجسم، فإنه يلتقط السوائل الزائدة والمواد الكيميائية والفضلات. وتعمل الكليتان على فصل هذه المواد عن الدم. ثم تخرج من الجسم عن طريق البول ");
            itemDetailsMap.put("الحالب", "الحالب هو جزء من الجهاز البولي، يتصل بالكلى ويصب بالمثانة، ووظيفته الأساسية تمرير البول وتوصيله حيث يتم إنتاجه في الكلية ثم ينتقل للمثانة ليتجمع هناك. أي خلل يصيب الجهاز البولي ككل، أو هذا العضو تحديداً، قد يتسبب في حدوث ألم الحالب المتقطع أو المستمر على فترات زمنية مختلفة، ويسمى هذان الأنبوبان الحالبين. تخزن المثانة البول حتى وقت التبول. ");
            itemDetailsMap.put("المثانة", "المثانة هي المكان الذي يجري فيه الاحتفاظ بالبول إلى أن يقوم الشخص بالتبوُّل. والمثانة العصبية هِيَ افتقار إلى ضبط المثانة بسبب مشاكل في الأعصاب التي تصِلُ إلى المثانة. تحُول بعضُ مشاكل الأعصاب دون انقباض عضلات المثانة بشكلٍ طبيعي، ثُمَّ تمتلئ المثانة بالبول الذي يتسرَّب");
        } else if (category.equals("تركيب الوحدة الأنبوبية الكلوية")) {
            itemDetailsList.add("محفظة بومان");
            itemDetailsList.add("الأنبوب الملتقي القريب");
            itemDetailsList.add("التواء هنلي");
            itemDetailsList.add("الأنبوب الملتوي البعيد");

            // Populate item details
            itemDetailsMap.put("محفظة بومان", " ي حوصلة تشبه الكوب توجد في بداية الجزء الانبوبي من الكليون Nephron في كلية الثدييات، وهي تمثل المرحلة الأولى في عملية تنقية الدم وتحويله إلى بول\n" +
                    "الوظيفة:\n" +
                    "تُحاط الكبيبة بتركيبٍ يُسمَّى محفظة الكبيبة، وتُسمَّى أيضًا «محفظة بومان»، يوجد في قشرة الكلية ويعمل على امتصاص الراشح الذي خرج من الدم. كما تنقل محفظة بومان الراشح إلى النفرونات");
            itemDetailsMap.put("الأنبوب الملتقي القريب",
                    "الأنيبيب الملتف القريب هو المكان الذي يعاد فيه امتصاص المواد المفيدة، مثل الجلوكوز وبعض الأيونات والماء إذا لزم الأمر، لتعود إلى مجرى الدم. وأخيرًا تفرغ الفضلات في القنوات الجامعة المتصلة بالنفرونات لتكوين البول. وتنقل القنوات الجامعة البول إلى الحالب، وهو الأنبوب الذي يصل بين الكليتين ");

            itemDetailsMap.put("التواء هنلي",
                    "هوالجزء من الكليون، أو الوحدة الكلوية الذي يتبع النبيبة القريبة، وتتشكل من طرف دقيق نازل يمر كمسافة مختلفة إلى النخاع الداخلي، وطرف دقيق صاعد يقع أيضاً في النخاع الداخلي. وطرف تخزين صاعد يقع في النخاع الخارجي وتلعب العروة دوراً مهماً في آلية مقوي التيار المضاد للنخاع");

            itemDetailsMap.put("الأنبوب الملتوي البعيد", " الوظيفة : هذه الأنابيب لها دور هام في إمتصاص و إفراز البوتاسيوم تحت تأثير هرمون الألدوستيرون و تصب في في الأنبوب  ");
        } else if (category.equals("خطوات تكوين البول")) {
            itemDetailsList.add("الترشيح");
            itemDetailsList.add("اعادة الامتصاص");
            itemDetailsList.add("الافراز الانبوبي");

            // Populate item details
            itemDetailsMap.put("الترشيح", "كيف يعمل الترشيح الكبيبي؟ \n"   +
                    " انتاج البول هي فصل الجزء السائل من الدم (البلازما)، الذي يحتوي على كل من المواد المذابة من خلايا الدم، كل نفرون في الكلتين لديه مرشح مجهري يسمى الكبيبة التي تقوم بترشيح الدم باستمرار. الدم المراد تصفيته يدخل الكبيبة، وهي خصلة من الشعيرات الدموية (أصغر الأوعية الدموية) \n" +
                    "الترشيح، على سبيل المثال، يفيد في فصل المواد الصلبة عن السوائل. وأحد الأمثلة على استخدامنا الترشيح في حياتنا اليومية هو استخلاص بقايا البن المطحون من كوب القهوة. من ناحية أخرى، يفيد التبلور في استخلاص المواد الصلبة من المحاليل. أحد الأمثلة على ذلك، الذي ربما صادفته، هو استخلاص كبريتات النحاس من محلول كبريتات النحاس.\n");
            itemDetailsMap.put("اعادة الامتصاص", "تتم اعادة امتصاص 99 بالمئة من السائل الراشح والغني بالمواد النافعة مثل الغلوكوز من خلال خلايا جذر الانابيب المكونة للوحدات الانبوبية الكلوية اما ما تبقى والذي يشكل حوالي 1% من السائل الراشح فيخرج على هيئة بول , تحدث إعادة الامتصاص في النبيبات الكلوية ويكون إما سلبيًا، بسبب الانتشار أو نشط، بسبب الضخ ضد تدرج التركيز. يتم الإفراز أيضا في النبيبات ويكون نشطا. تشمل المواد التي يتم إعادة امتصاصها: الماء، والصوديوم، والكلوريد، والجلوكوز، وأحماض أمينية، ولاكتات، والمغنسيوم، والكالسيوم، والفوسفات، وحمض اليوريك، والبيكربونات");
            itemDetailsMap.put("الافراز الانبوبي", " الافراز الانبوبي : بعض المواد لا ترشح  من الكبة الى تجويف بومان  مثل ايوانات الهيدروجين وايونات البوتاسيوم ويتم التخلث منها بعملية انتقائية حيث تسير في الشريين الصادر حتى تصل الى الانبوب الملتوي البعيد فتقوم خلايا جدار الانبوب بفصلها عن الدم واضافتها الى مكونات البول ");

        }
        // Create ArrayAdapter to populate the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemDetailsList);
        listView.setAdapter(adapter);
    }
}
