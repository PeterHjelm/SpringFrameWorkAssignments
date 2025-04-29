package se.yrgo.services.calls;

import se.yrgo.domain.Action;
import se.yrgo.domain.Call;
import se.yrgo.services.customers.CustomerManagementService;
import se.yrgo.services.customers.CustomerNotFoundException;
import se.yrgo.services.diary.DiaryManagementService;

import java.util.Collection;
import java.util.List;

public class CallHandlingServiceImp implements CallHandlingService {
private DiaryManagementService diaryManagementService;
private CustomerManagementService customerManagementService;

public CallHandlingServiceImp(DiaryManagementService diaryManagementService, CustomerManagementService customerManagementService) {
    this.diaryManagementService = diaryManagementService;
    this.customerManagementService = customerManagementService;
}

    @Override
    public void recordCall(String customerId, Call newCall, Collection<Action> actions) throws CustomerNotFoundException {
        for(Action action : actions) {
            diaryManagementService.recordAction(action);
        }
    }

    @Override
    public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
        customerManagementService.recordCall(customerId, callDetails);
    }

    public void recordAction(String customerId, Action action) throws CustomerNotFoundException {
        diaryManagementService.recordAction(action);
    }

    public List<Action> getAllIncompleteActions(String requiredUser) {
        return diaryManagementService.getAllIncompleteActions(requiredUser);
    }
}
