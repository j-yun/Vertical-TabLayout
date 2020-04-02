# VerticalTabLayout

![](https://github.com/j-yun/VerticalTabLayout/blob/master/demo.png?raw=true)


## how to use:
### gradle
#### project level
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

#### app level
    dependencies {
	        implementation 'com.github.j-yun:Vertical-TabLayout:1.0.2'
	}

### xml

    <q.rorbin.verticaltablayout.VerticalTabLayout
        android:id="@+id/tablayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#EDEDED"
        app:indicator_color="#FFFFFF"
        app:indicator_gravity="fill"
        app:tab_height="50dp"
        app:tab_mode="scrollable" />

### Custom layout properties

xml | code
---|---|---
app:indicator_color | setIndicatorColor
app:indicator_width | setIndicatorWidth
app:indicator_gravity | setIndicatorGravity
app:indicator_corners | setIndicatorCorners
app:tab_mode | setTabMode
app:tab_height | setTabHeight
app:tab_margin | setTabMargin

### Implementation
- See the demo project for detailed usage.

- Fully customized

	``tablayout.addTab(new QTabView(context))``

		tablayout.setOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(View tab, int position) {
                
            }

            @Override
            public void onTabReselected(View tab, int position) {

            }
        });

- Implement TabAdapter

		tablayout.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public View getTabItemView(int position) {
                return yourView;
            }
	     });
	     
  
- Use ViewPager & PagerAdapter ( implement TabAdapter in Your PagerAdapter )

    `tablayout.setupWithViewPager(viewpager);`


## License
    Copyright 2016, RorbinQiu

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.