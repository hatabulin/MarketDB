package com.example.test.model.events;

import com.example.test.utils.fragments.FragmentsAnimationId;
import com.example.test.utils.fragments.FragmentsId;

public interface FragmentChangedEvent {

    void changeFragment(FragmentsId fragmentsId, FragmentsAnimationId fragmentsAnimationId);

    //
    void setFragment(FragmentsId fragmentsId);
}
