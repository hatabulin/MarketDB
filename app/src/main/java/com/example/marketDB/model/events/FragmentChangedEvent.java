package com.example.marketDB.model.events;

import com.example.marketDB.utils.fragments.FragmentsAnimationId;
import com.example.marketDB.utils.fragments.FragmentsId;

public interface FragmentChangedEvent {

    void changeFragment(FragmentsId fragmentsId, FragmentsAnimationId fragmentsAnimationId);

    //
    void setFragment(FragmentsId fragmentsId);
}
