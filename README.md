# Ocha
Lottie Animation SeekBar
<img src="https://user-images.githubusercontent.com/45986582/77251693-241b9080-6c93-11ea-8726-374b2c1f7585.gif" width="350" />

# DownLoad
```
implementation 'sobaya.app.ocha:ocha:1.0.0'
```

# Introduction
Add Layout Ocha
```
<sobaya.app.ocha.Ocha
    android:layout_width="match_parent"
    android:layout_height="500dp"
    app:frame="@={viewModel.frame}"
    app:maxFrame="40"
    app:rawRes="@raw/weight"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

ViewModel
```
val frame = MutableLiveData<Int>()
```

Activity/Fragment
```
mainViewModel.frame.observe(this, Observer {
    Log.d("OCHA", it.toString())
})
```
