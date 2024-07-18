package com.example.chattingapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val context: Context, private val userList: ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        //user_layout 연결하는 기능 구현
        val view: View = LayoutInflater.from(context).
        inflate(R.layout.user_layout,parent,false)    //user_layout을 view변수에 넣고

        return UserViewHolder(view)  //view변수를 UserViewHolder 생성자에 넣음
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        //데이터를 전달 받아 user_layout에 보여주는 기능 구현
        val currentUser = userList[position]  //userList안의 데이터를 순서대로 currentUser에 넣음

        //화면에 데이터 보여주기
        holder.nameText.text = currentUser.name  // currentUser에 있는 이름을 nameText에 넣음

        //아이템 클릭 이벤트
        holder.itemView.setOnClickListener{
            val intent = Intent(context,ChatActivity::class.java)

            //넘길 데이터
            intent.putExtra("name",currentUser.name)
            intent.putExtra("uId",currentUser.uId)

            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        //userList의 갯수를 돌려줌
        return userList.size
    }

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val nameText: TextView = itemView.findViewById(R.id.name_text)
    }
}