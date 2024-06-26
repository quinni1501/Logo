package vn.superandroid.logo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import vn.superandroid.logo.Activities.ProfileActivity;

public class BottomSheetDialog extends BottomSheetDialogFragment {
    public Button chooseImg;
    private boolean ck = false;
    ImageView imgAvatar;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_bottom_sheet,
                container, false);

        chooseImg = v.findViewById(R.id.choose_img_button);
        Button uploadImg = v.findViewById(R.id.upload_img_button);

        chooseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        uploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
                        "Course Shared", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        return v;
    }
}
