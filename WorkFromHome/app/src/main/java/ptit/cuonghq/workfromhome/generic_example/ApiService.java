package ptit.cuonghq.workfromhome.generic_example;

import io.reactivex.observers.DisposableObserver;

public class ApiService {

    public static <T> DisposableObserver<Response<T>> disposableObserver(final ApiCallback<T> callback) {
        return new DisposableObserver<Response<T>>() {
            @Override
            public void onNext(Response<T> t) {
                if (t.isSuccess()) {
                    callback.success(t.getData());
                } else {
                    callback.failed(t.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                callback.failed(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }

    public static <T> DisposableObserver<ListResponse<T>> listResponseDisposableObserver(final ApiListCallback <T> callback) {
        return new DisposableObserver<ListResponse<T>>() {
            @Override
            public void onNext(ListResponse<T> t) {
                if (t.isSuccess()) {
                    callback.success(t.getData());
                } else {
                    callback.failed(t.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                callback.failed(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }
}
