FloatingActionButton
====================
Yet another library for drawing [Material Design promoted actions](http://www.google.com/design/spec/patterns/promoted-actions.html).

This library supports API 7+.

Features
========
* Support all features from its' base version: [FloatingActionButton](ttps://github.com/str4d/android-floating-action-button)
* Scroll handler listener custom and animations:
    Scale:

    TranslationY:     

Usage
=====
Just add the dependency to your `build.gradle`:

```groovy
dependencies {
    compile 'toan.android:floatingactionbutton:1.0'
}
```

The library is available on Maven Central (`mavenCentral()` in your repositories list).

Alternatively, you can build it manually and install it in your local Maven repo:

```
git clone https://github.com/toanvc/android-floating-action-button
cd android-floating-action-button
cd library
gradle installArchives
```

Then add `mavenLocal()` to the top of your repositories list (so it is checked first).

To see how the buttons are added to your xml layouts, check the sample project.


Credits
=======
This library is a extended version of the [FloatingActionButton](https://github.com/str4d/android-floating-action-button) library by [str4d](https://github.com/str4d).

That library used [FloatingActionButton](https://github.com/makovkastar/FloatingActionButton) library by [Oleksandr Melnykov](https://github.com/makovkastar) as a base for development for handler of scroll.

License
=======
    Copyright (C) 2016 toanvc
    Copyright (C) 2014 str4d
    Copyright (C) 2014 Jerzy Chalupski

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
