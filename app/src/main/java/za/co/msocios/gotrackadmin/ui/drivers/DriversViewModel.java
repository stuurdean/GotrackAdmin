package za.co.msocios.gotrackadmin.ui.drivers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DriversViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    public DriversViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Drivers fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}