package se.yrgo.services.calls;

import se.yrgo.domain.Action;
import se.yrgo.domain.Call;
import se.yrgo.services.customers.CustomerNotFoundException;
import se.yrgo.services.diary.DiaryManagementService;
import se.yrgo.services.diary.DiaryManagementServiceMockImpl;

import java.util.Collection;
import java.util.List;

public class CallHandlingServiceImp implements CallHandlingService {
private DiaryManagementService diaryManagementService;

public CallHandlingServiceImp(DiaryManagementService diaryManagementService) {
    this.diaryManagementService = diaryManagementService;
}

    @Override
    public void recordCall(String customerId, Call newCall, Collection<Action> actions) throws CustomerNotFoundException {
        for(Action action : actions) {
            diaryManagementService.recordAction(action);
        }
    }
    public void recordAction(String customerId, Action action) throws CustomerNotFoundException {
        diaryManagementService.recordAction(action);
    }

    public List<Action> getAllIncompleteActions(String requiredUser) {
        return diaryManagementService.getAllIncompleteActions(requiredUser);
    }
}
