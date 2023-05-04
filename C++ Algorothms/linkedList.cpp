#include <iostream>

//linked list
struct Node {
    int data;
    Node *next;
};

Node *head = nullptr;
Node *tail = nullptr;

// add node

 void addNode(int data)
 {
    Node *temp=new Node();
    temp->data=data;
    temp->next=nullptr;
     
    if(head==nullptr)
    {
        head=temp;
        tail=temp;
        temp=nullptr;
    }
    else
    {
        tail->next=temp;
        tail=temp;
    }

 }

// display elements

 void display()
 {
    Node *temp = head;
    while (temp != nullptr)
    {
        std::cout << temp->data << " ";
        temp = temp->next;
    }
 }

 // delete node

 void deleteNode(int data)
 {
    Node *temp = head;
    Node *prev = nullptr;

    while (temp != nullptr && temp->data != data)
    {
        prev = temp;
        temp = temp->next;
    }

    if (temp == nullptr)
    {
        std::cout << "Element not found in the list" << std::endl;
        return;
    }

    if (prev == nullptr)
    {
        head = temp->next;
    }
    else
    {
        prev->next = temp->next;
    }

    delete temp;
 }

 // search node

 bool searchNode(int data)
 {
    Node *temp = head;
    while (temp != nullptr)
    {
        if (temp->data == data)
        {
            return true;
        }
        temp = temp->next;
    }
    return false;
 }

int main()
{




    return 0;
}