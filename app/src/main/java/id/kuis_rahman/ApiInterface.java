package id.kuis_rahman;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("buat_account")
    Call<Akun> buat_account(@Query("id") String id, @Query("passwd") String passwd);
    @GET("cek_saldo")
    Call<Akun> cek_saldo(@Query("id") String id, @Query("passwd") String passwd);
    @POST("transfer_coin")
    Call<Akun> transfer_coin(@Query("id") String id, @Query("passwd") String passwd,
                             @Query("id_tujuan") String id_tujuan, @Query("jumlah") String jumlah);
}
