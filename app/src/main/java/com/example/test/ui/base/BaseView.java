package com.example.test.ui.base;

public interface BaseView {
    /**
     * Базовый Presenter
     */
    interface Presenter<T extends RootView> {
        /**
         * Передает view в presenter.
         *
         * @param view the view
         */
        void bindView(T view);

        /**
         * Отписывается от запущенных задач, удаляет ссылку на view.
         */
        void unbindView();

        /**
         * Оповесчает что view готово.
         */
        void onViewCreated();
    }

    /**
     * Базовый интерфейс для View
     */
    interface RootView {

    }
}