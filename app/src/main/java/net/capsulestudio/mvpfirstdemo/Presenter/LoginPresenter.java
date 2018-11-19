package net.capsulestudio.mvpfirstdemo.Presenter;

import net.capsulestudio.mvpfirstdemo.Model.User;
import net.capsulestudio.mvpfirstdemo.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int  isLoginSuccess = user.isValidateData();

        if (isLoginSuccess == 0){
            iLoginView.onLoginError("Email Must Not Be Empty");
        }else if (isLoginSuccess == 1){
            iLoginView.onLoginError("You Must Enter Valid Email");
        }else if (isLoginSuccess == 2){
            iLoginView.onLoginError("Password Length Must be greater than 6");
        }else {
            iLoginView.onLoginSuccess("Login Successful");
        }

    }
}
