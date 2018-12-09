package mobile.checkcar.org.wat.pl.app.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.checkcar.org.wat.pl.app.R;
import mobile.checkcar.org.wat.pl.app.Utils.PersonUtils;
import mobile.checkcar.org.wat.pl.app.Utils.RetrofitUtils;
import mobile.checkcar.org.wat.pl.app.service.PersonService;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_name)
    EditText loginName;

    @BindView(R.id.login_password)
    EditText loginPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        RetrofitUtils.initRetrofir();
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_button)
    public void onLoginButtonClick() {
        String username = loginName.getText().toString();
        String password = loginPassword.getText().toString();

        new AsyncTask<String,Void,PersonDto>(){

            @Override
            protected PersonDto doInBackground(String... strings) {
                String usernameString = strings[0];
                PersonService personService = RetrofitUtils.retrofit.create(PersonService.class);

                try {
                    Response response = personService.getPerson(usernameString).execute();

                    if(response.body() != null){
                        return (PersonDto) response.body();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(PersonDto personDto) {
                super.onPostExecute(personDto);
                if(personDto != null){
                    PersonUtils.setLoggedPerson(personDto);
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Coś poszło nie tak. Spróbuj jeszcze raz później", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute(username);


    }

}
