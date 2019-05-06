package ptit.cuonghq.workfromhome.generic_example;

public interface ApiCallback<T> {
    void success(T data);

    void failed(String msg);
}
