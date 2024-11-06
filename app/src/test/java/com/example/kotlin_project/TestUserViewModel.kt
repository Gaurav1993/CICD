package com.example.kotlin_project

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class TestUserViewModel
{

    @get:Rule
    val instanttaskexecutorrule = InstantTaskExecutorRule()
    @Mock
    private lateinit var mockuserdao:User_Dao
    private lateinit var mockuserrepository:UserRepository
    private lateinit var mockviewmodel:UserViewModel
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup()
    {
        MockitoAnnotations.openMocks(this)
        mockuserdao = mock(User_Dao::class.java)
        mockuserrepository = UserRepository(mockuserdao)
        mockviewmodel = UserViewModel(mockuserrepository)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun testfeatchUser() = runTest {
        var user= listOf(User(name = "Gaurav", email = "gaurav.singh881@gmail.com", password = "123456", mobile = "1234567890"))
       `when`(mockuserdao.getAllUser()).thenReturn(user)

        val obser = Observer<List<User>>{users->

            assertEquals(user,users)

        }
        mockviewmodel.users.observeForever(obser)
        mockviewmodel.getUsers()
        testDispatcher.scheduler.advanceUntilIdle()
        assertEquals(user,mockviewmodel.users.value)
    }


}