#include "org_example_jni_HelloNative.h"
#include "pch.h"
#include "jni.h"
#include <iostream>
using namespace std;
JNIEXPORT void JNICALL Java_org_example_jni_HelloNative_greeting(JNIEnv* env, jclass cl) {
    cout << "Hello, world!2" << endl;
}