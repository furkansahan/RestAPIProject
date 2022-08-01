package com.furkansahan;
import com.furkansahan.model.User;
import org.springframework.ui.Model;

import java.util.List;

public interface TestTaskData {

    //Save
    public void testCreate();

    //fail save test
    public void testCreateFail();



    //Test
    public void testList();

    //Update
    public void testUpdate();

    //Delete
    public void testDelete();

}
