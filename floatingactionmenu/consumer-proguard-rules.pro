# keep getters/setters in RotatingDrawable so that animations can still work.
-keepclassmembers class toan.android.floatingactionbutton.FloatingActionsMenu$RotatingDrawable {
   void set*(***);
   *** get*();
}
