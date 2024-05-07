package DI

import android.app.Application
import androidx.room.Room
import com.example.practice_number_3.Data.data_source.TaskDatabase
import com.example.practice_number_3.Data.repository.RepositoryImpl
import com.example.practice_number_3.Domain.repository.Repository
import com.example.practice_number_3.Domain.use_case.AddTask
import com.example.practice_number_3.Domain.use_case.DeleteTask
import com.example.practice_number_3.Domain.use_case.GetTask
import com.example.practice_number_3.Domain.use_case.GetTasks
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDataBase(application: Application):TaskDatabase{
        return Room.databaseBuilder(application,TaskDatabase::class.java,"task_db")
            .build()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(db:TaskDatabase):Repository{
        return RepositoryImpl(db.taskDao)
    }

    @Provides
    @Singleton
    fun provideGetTasks(repository: Repository):GetTasks{
        return GetTasks(repository)
    }
    @Provides
    @Singleton
    fun provideAddTask(repository: Repository):AddTask{
        return AddTask(repository)
    }
    @Provides
    @Singleton
    fun provideDeleteTask(repository: Repository): DeleteTask {
        return DeleteTask(repository)
    }
    @Provides
    @Singleton
    fun provideGetTask(repository: Repository): GetTask {
        return GetTask(repository)
    }

}